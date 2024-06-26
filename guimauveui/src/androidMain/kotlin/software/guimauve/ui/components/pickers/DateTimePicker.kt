package software.guimauve.ui.components.pickers

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import kotlinx.datetime.LocalDateTime
import software.guimauve.extensions.renderedDate
import software.guimauve.extensions.renderedTime
import java.util.*

@Composable
@Suppress("FunctionName")
fun DateTimePicker(
    modifier: Modifier = Modifier,
    selected: LocalDateTime?,
    placeholder: String = "",
    onSelected: (LocalDateTime) -> Unit,
) {

    val context = LocalContext.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            leadingIcon = {
                Text(
                    text = selected?.renderedDate ?: placeholder,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = if (selected != null) MaterialTheme.colorScheme.onSurface
                        else Color.LightGray
                    ),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clickable {
                            DatePickerDialog(
                                context,
                                { _, year, month, dayOfMonth ->
                                    onSelected(
                                        LocalDateTime(
                                            year,
                                            month + 1,
                                            dayOfMonth,
                                            selected?.hour ?: 0,
                                            selected?.minute ?: 0
                                        )
                                    )
                                },
                                selected?.year ?: Calendar
                                    .getInstance()
                                    .get(Calendar.YEAR),
                                (selected?.monthNumber ?: (Calendar
                                    .getInstance()
                                    .get(Calendar.MONTH) + 1)) - 1,
                                selected?.dayOfMonth ?: Calendar
                                    .getInstance()
                                    .get(Calendar.DAY_OF_MONTH)
                            ).show()
                        }
                )
            },
            value = "",
            onValueChange = {},
            modifier = Modifier.weight(1f)
        )
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
                                    onSelected(
                                        LocalDateTime(
                                            selected?.year ?: 0,
                                            selected?.monthNumber ?: 0,
                                            selected?.dayOfMonth ?: 0,
                                            hourOfDay,
                                            minute
                                        )
                                    )
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
            modifier = Modifier.weight(1f)
        )
    }

}
