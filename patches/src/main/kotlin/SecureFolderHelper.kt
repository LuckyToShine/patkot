package patches

import android.content.Context
import android.os.Bundle
import android.util.Log

/**
 * Reverse-engineered helper for Samsung One UI "Move to Secure Folder" feature.
 * Uses reflection to interact with Knox SemPersonaManager & SemRemoteContentManager services.
 */
object SecureFolderHelper {
    private const val TAG = "SecureFolderHelper"
    private const val PERSONA_SERVICE = "persona"
    private const val RCP_SERVICE = "rcp"
    private const val SECURE_FOLDER_CONTAINER_TYPE = 1002
    private const val MOVE_TO_CONTAINER_OP = 1

    /**
     * Checks if Secure Folder is active and available on the device.
     */
    fun isSecureFolderAvailable(context: Context): Boolean {
        return getSecureFolderContainerId(context) != -1
    }

    /**
     * Queries Samsung Knox SemPersonaManager to retrieve the Secure Folder container ID.
     * Container type 1002 corresponds to Secure Folder.
     */
    fun getSecureFolderContainerId(context: Context): Int {
        return try {
            val personaManager = context.getSystemService(PERSONA_SERVICE) ?: return -1
            val getMenuListMethod = personaManager.javaClass.getMethod("getMoveToKnoxMenuList", Context::class.java)
            @Suppress("UNCHECKED_CAST")
            val menuList = getMenuListMethod.invoke(personaManager, context) as? List<Bundle> ?: return -1

            for (bundle in menuList) {
                val containerType = bundle.getInt("com.sec.knox.moveto.containerType", -1)
                if (containerType == SECURE_FOLDER_CONTAINER_TYPE) {
                    val containerId = bundle.getInt("com.sec.knox.moveto.containerId", -1)
                    Log.d(TAG, "Found Secure Folder Container ID: $containerId")
                    return containerId
                }
            }
            -1
        } catch (e: Exception) {
            Log.w(TAG, "Failed to query Secure Folder container ID: ${e.message}")
            -1
        }
    }

    /**
     * Moves a list of file paths to Samsung Secure Folder via SemRemoteContentManager.
     */
    fun moveToSecureFolder(context: Context, filePaths: List<String>): Boolean {
        if (filePaths.isEmpty()) return false

        val containerId = getSecureFolderContainerId(context)
        if (containerId == -1) {
            Log.e(TAG, "Cannot move to Secure Folder: Secure Folder is not active or container ID not found")
            return false
        }

        return try {
            val rcpManager = context.getSystemService(RCP_SERVICE)
                ?: throw IllegalStateException("RCP system service ('rcp') is not available on this device")

            val pathsList = ArrayList(filePaths)
            val moveFilesMethod = rcpManager.javaClass.getMethod(
                "moveFiles",
                Int::class.javaPrimitiveType,
                ArrayList::class.java,
                ArrayList::class.java,
                Int::class.javaPrimitiveType
            )

            moveFilesMethod.invoke(rcpManager, MOVE_TO_CONTAINER_OP, pathsList, pathsList, containerId)
            Log.i(TAG, "Successfully sent ${filePaths.size} file(s) to Secure Folder (Container ID: $containerId)")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error moving files to Secure Folder: ${e.message}", e)
            false
        }
    }
}
