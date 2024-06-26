package software.guimauve.sample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import com.jamal.composeprefs3.ui.PrefsScreen
import software.guimauve.ui.components.guimauveApps

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "compose")

class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    PrefsScreen(
                        dataStore = LocalContext.current.dataStore
                    ) {
                        guimauveApps()
                    }
                }
            }
        }
    }

}
