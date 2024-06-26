package software.guimauve.extensions

import software.guimauve.models.GuimauveApp
import software.guimauve.models.PlatformGuimauveApp
import kotlin.enums.EnumEntries

internal fun GuimauveApp.platformApp(url: GuimauveApp.() -> String?) =
    url()?.let { PlatformGuimauveApp(displayName, description, icon, it) }

val EnumEntries<GuimauveApp>.ios: List<PlatformGuimauveApp>
    get() = mapNotNull { it.platformApp { iosUrl } }

val EnumEntries<GuimauveApp>.android: List<PlatformGuimauveApp>
    get() = mapNotNull { it.platformApp { androidUrl } }
