package software.guimauve.extensions

import software.guimauve.models.GuimauveApp
import software.guimauve.native.SwiftUIGuimauveApp
import kotlin.enums.EnumEntries

internal fun GuimauveApp.swiftUI(url: GuimauveApp.() -> String?) =
    url()?.let { SwiftUIGuimauveApp(title, text.key, swiftUIIcon!!, it) }

val EnumEntries<GuimauveApp>.swiftUI: List<SwiftUIGuimauveApp>
    get() = mapNotNull { it.swiftUI { iosUrl } }
