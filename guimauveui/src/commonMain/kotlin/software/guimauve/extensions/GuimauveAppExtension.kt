package software.guimauve.extensions

import software.guimauve.models.apps.GuimauveApp
import software.guimauve.models.apps.PlatformGuimauveApp
import kotlin.enums.EnumEntries

internal fun GuimauveApp.platformApp(url: GuimauveApp.() -> String?) =
    url()?.let { PlatformGuimauveApp(title, text, icon, it) }

val EnumEntries<GuimauveApp>.ios: List<PlatformGuimauveApp>
    get() = mapNotNull { it.platformApp { iosUrl } }

val EnumEntries<GuimauveApp>.android: List<PlatformGuimauveApp>
    get() = mapNotNull { it.platformApp { androidUrl } }
