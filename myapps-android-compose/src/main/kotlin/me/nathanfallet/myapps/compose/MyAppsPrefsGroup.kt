package me.nathanfallet.myapps.compose

import androidx.compose.ui.res.stringResource
import com.jamal.composeprefs3.ui.GroupHeader
import com.jamal.composeprefs3.ui.PrefsScope
import me.nathanfallet.myapps.android.R
import me.nathanfallet.myapps.extensions.android
import me.nathanfallet.myapps.models.MyApp

fun PrefsScope.myApps() {
    prefsGroup({
        GroupHeader(
            title = stringResource(id = R.string.header)
        )
    }) {
        MyApp.entries.android.forEach { app ->
            prefsItem {
                MyAppPref(app)
            }
        }
    }
}
