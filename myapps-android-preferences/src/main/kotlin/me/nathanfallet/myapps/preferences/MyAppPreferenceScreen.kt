package me.nathanfallet.myapps.preferences

import android.content.Intent
import android.net.Uri
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceScreen
import me.nathanfallet.myapps.android.R
import me.nathanfallet.myapps.extensions.android
import me.nathanfallet.myapps.models.MyApp

fun PreferenceScreen.myApps() {
    val category = PreferenceCategory(context)
    category.setTitle(R.string.header)
    addPreference(category)

    MyApp.entries.android.forEach { app ->
        val preference = MyAppPreference(context)
        preference.title = app.displayName
        preference.setSummary(app.description)
        preference.setIcon(app.icon)
        preference.intent = Intent(Intent.ACTION_VIEW, Uri.parse(app.url))
        category.addPreference(preference)
    }
}
