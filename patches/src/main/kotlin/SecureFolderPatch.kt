package patches

import android.content.Context
import android.widget.Toast

/**
 * Morphe / ReVanced style patch definition for Iris Gallery 0.70.
 *
 * This patch integrates Samsung "Save/Move to Secure Folder" feature into Iris Gallery.
 */
object SecureFolderPatch {

    /**
     * Entry point to execute "Move to Secure Folder" action from Iris Gallery UI.
     * Can be invoked from media item context menus, photo viewer action bars, or multi-select menus.
     *
     * @param context Application or Activity context.
     * @param filePaths List of file absolute paths to be moved into Secure Folder.
     */
    fun onMoveToSecureFolderClicked(context: Context, filePaths: List<String>) {
        if (!SecureFolderHelper.isSecureFolderAvailable(context)) {
            Toast.makeText(context, "Secure Folder is not available or enabled on this Samsung device", Toast.LENGTH_SHORT).show()
            return
        }

        val success = SecureFolderHelper.moveToSecureFolder(context, filePaths)
        if (success) {
            Toast.makeText(context, "Moving ${filePaths.size} item(s) to Secure Folder...", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to move files to Secure Folder", Toast.LENGTH_SHORT).show()
        }
    }
}
