package software.guimauve.models

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class PlatformGuimauveApp(
    val displayName: String,
    val description: StringResource,
    val icon: DrawableResource,
    val url: String,
)
