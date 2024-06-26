package software.guimauve.ui.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun DefaultNavigationBarButton(
    onClick: () -> Unit,
    hasImage: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    IconButton(
        onClick = onClick,
        content = content,
        modifier = modifier
            .padding(if (hasImage) 16.dp else 0.dp)
            .background(
                color = if (hasImage) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent,
                shape = CircleShape
            )
    )
}
