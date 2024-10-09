package software.guimauve.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object DefaultTheme {

    val backgroundColor = Color(0xFFF2F2F7)
    val darkBackgroundColor = Color(0xFF000000)

    val cardColor = Color(0xFFFFFFFF)
    val darkCardColor = Color(0xFF1E1E1E)

    val shapes = Shapes(
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(12.dp),
        large = RoundedCornerShape(16.dp)
    )

    @Composable
    fun defaultCardColors() = cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    )

}
