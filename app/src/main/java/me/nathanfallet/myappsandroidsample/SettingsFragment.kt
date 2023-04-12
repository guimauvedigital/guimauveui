package me.nathanfallet.myappsandroidsample

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import me.nathanfallet.myappsandroid.preferences.MyAppPreferences

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        MyAppPreferences.addPreferences(preferenceScreen)
    }
}