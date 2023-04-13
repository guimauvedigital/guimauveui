package me.nathanfallet.myappsandroid.compose

import androidx.compose.ui.res.stringResource
import com.jamal.composeprefs.ui.GroupHeader
import com.jamal.composeprefs.ui.PrefsScope
import me.nathanfallet.myappsandroid.R
import me.nathanfallet.myappsandroid.models.MyApp

fun PrefsScope.myApps() {
    prefsGroup({
        GroupHeader(
            title = stringResource(id = R.string.header)
        )
    }) {
        MyApp.values().forEach { app ->
            prefsItem {
                MyAppPref(app)
            }
        }
    }
}
