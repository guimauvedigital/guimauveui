package software.guimauve.extensions

import android.text.format.DateFormat
import kotlinx.datetime.*

val LocalDate.renderedDate: String
    get() = atStartOfDayIn(TimeZone.currentSystemDefault()).renderedDate

val LocalTime.renderedTime: String
    get() = "1970-01-01T${toString()}Z".let(Instant::parse).renderedTime

val LocalDateTime.renderedDate: String
    get() = date.renderedDate

val LocalDateTime.renderedTime: String
    get() = time.renderedTime

val Instant.renderedDate: String
    get() = DateFormat.format("d MMMM yyyy", toEpochMilliseconds()).toString()

val Instant.renderedTime: String
    get() = DateFormat.format("HH:mm", toEpochMilliseconds()).toString()
