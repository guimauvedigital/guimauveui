package software.guimauve.ui.components

import com.jamal.composeprefs3.ui.GroupHeader
import com.jamal.composeprefs3.ui.PrefsScope
import org.jetbrains.compose.resources.stringResource
import software.guimauve.Res
import software.guimauve.extensions.android
import software.guimauve.header
import software.guimauve.models.GuimauveApp

fun PrefsScope.guimauveApps() {
    prefsGroup({
        GroupHeader(
            title = stringResource(Res.string.header)
        )
    }) {
        GuimauveApp.entries.android.forEach { app ->
            prefsItem {
                GuimauveAppPref(app)
            }
        }
    }
}
