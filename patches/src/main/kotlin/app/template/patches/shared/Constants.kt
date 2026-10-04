package app.template.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY_CINEVI = Compatibility(
        name = "Cinevi",
        packageName = "com.movievn.cinevi",
        apkFileType = ApkFileType.APK,
        appIconColor = 0xE50914,
        targets = listOf(
            AppTarget(
                version = "4.0.0"
            )
        )
    )
}
