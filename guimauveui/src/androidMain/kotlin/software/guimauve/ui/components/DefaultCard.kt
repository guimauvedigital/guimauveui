package software.guimauve.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import software.guimauve.Res
import software.guimauve.latexcards

@Composable
@Suppress("FunctionName")
fun DefaultCard(
    image: @Composable (Modifier) -> Unit,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            image(Modifier.size(76.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                )
                Text(
                    text = description,
                    color = Color.Gray
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Preview
@Composable
@Suppress("FunctionName")
fun DefaultCardPreview() {
    DefaultCard(
        image = {
            Image(
                painter = painterResource(Res.drawable.latexcards),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = it
            )
        },
        title = "Title",
        description = "Description"
    )
}
