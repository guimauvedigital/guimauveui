package me.nathanfallet.myappsandroidsample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import com.jamal.composeprefs.ui.PrefsScreen
import me.nathanfallet.myappsandroidcompose.myApps

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "compose")

class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    PrefsScreen(
                        dataStore = LocalContext.current.dataStore
                    ) {
                        myApps()
                    }
                }
            }
        }
    }

}