package app.czyeru.patches.tiktok.misc.navigation

import app.morphe.patcher.Fingerprint

internal object TopTabModelListFingerprint : Fingerprint(
    definingClass = "/TabAbilityAssem;",
    name = "K9",
    returnType = "Ljava/util/List;",
    parameters = listOf(),
)

internal object BottomTabModelListFingerprint : Fingerprint(
    definingClass = "/TabAbilityAssem;",
    name = "OB",
    returnType = "Ljava/util/List;",
    parameters = listOf(),
)
