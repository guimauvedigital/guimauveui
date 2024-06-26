package software.guimauve.models.apps

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class PlatformGuimauveApp(
    val title: String,
    val text: StringResource,
    val icon: DrawableResource,
    val url: String,
)
