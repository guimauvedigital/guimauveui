package me.nathanfallet.myappsandroid.preferences

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceScreen
import me.nathanfallet.myappsandroid.R
import me.nathanfallet.myappsandroid.models.MyApp

class MyAppPreferences {

    fun addPreferences(screen: PreferenceScreen, activity: Activity) {
        val category = PreferenceCategory(screen.context)
        category.setTitle(R.string.header)
        screen.addPreference(category)

        MyApp.values().forEach { app ->
            val preference = MyAppPreference(screen.context)
            preference.title = app.displayname
            preference.setSummary(app.description)
            preference.setIcon(app.icon)
            preference.setOnPreferenceClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(app.url))
                activity.startActivity(browserIntent)
                true
            }
            category.addPreference(preference)
        }
    }

}