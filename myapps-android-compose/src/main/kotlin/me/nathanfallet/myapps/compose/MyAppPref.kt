package me.nathanfallet.myapps.compose

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.jamal.composeprefs3.ui.prefs.TextPref
import me.nathanfallet.myapps.models.MyAppAndroid

@Composable
@Suppress("FunctionName")
fun MyAppPref(myApp: MyAppAndroid) {
    val context = LocalContext.current

    TextPref(
        title = myApp.displayName,
        summary = stringResource(id = myApp.description),
        leadingIcon = {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = myApp.icon),
                    contentDescription = myApp.displayName,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp,
                                bottomStart = 8.dp,
                                bottomEnd = 8.dp
                            )
                        )
                )
            }
        },
        onClick = {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(myApp.url)
            )
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(
                context,
                browserIntent,
                null
            )
        },
        enabled = true
    )
}
