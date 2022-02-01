package me.nathanfallet.myappsandroid.preferences

import android.content.Intent
import android.net.Uri
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceScreen
import me.nathanfallet.myappsandroid.R
import me.nathanfallet.myappsandroid.models.MyApp

class MyAppPreferences {

    fun addPreferences(screen: PreferenceScreen) {
        val category = PreferenceCategory(screen.context)
        category.setTitle(R.string.header)
        screen.addPreference(category)

        MyApp.values().forEach { app ->
            val preference = MyAppPreference(screen.context)
            preference.title = app.displayname
            preference.setSummary(app.description)
            preference.setIcon(app.icon)
            preference.intent = Intent(Intent.ACTION_VIEW, Uri.parse(app.url))
            category.addPreference(preference)
        }
    }

}