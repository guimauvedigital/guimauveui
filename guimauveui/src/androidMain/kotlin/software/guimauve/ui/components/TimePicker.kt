package software.guimauve.ui.components

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.LocalTime
import software.guimauve.extensions.renderedTime
import java.util.*

@Composable
@Suppress("FunctionName")
fun TimePicker(
    modifier: Modifier = Modifier,
    selected: LocalTime?,
    placeholder: String = "",
    onSelected: (LocalTime) -> Unit,
) {

    val context = LocalContext.current

    OutlinedTextField(
        leadingIcon = {
            Text(
                text = selected?.renderedTime ?: placeholder,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = if (selected != null) MaterialTheme.colorScheme.onSurface
                    else Color.LightGray
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .clickable {
                        TimePickerDialog(
                            context,
                            { _, hourOfDay, minute ->
                                onSelected(LocalTime(hourOfDay, minute))
                            },
                            selected?.hour ?: Calendar
                                .getInstance()
                                .get(Calendar.HOUR_OF_DAY),
                            selected?.minute ?: Calendar
                                .getInstance()
                                .get(Calendar.MINUTE),
                            true
                        ).show()
                    }
            )
        },
        value = "",
        onValueChange = {},
        modifier = modifier
    )

}
