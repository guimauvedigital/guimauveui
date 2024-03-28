package me.nathanfallet.myapps.sample

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import me.nathanfallet.myapps.preferences.myApps

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        preferenceScreen.myApps()
    }

}
