package software.guimauve.ui.components.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import software.guimauve.Res
import software.guimauve.back
import software.guimauve.latexcards

@Composable
@Suppress("FunctionName")
fun DefaultNavigationBar(
    title: String,
    navigateUp: (() -> Unit)? = null,
    toolbar: @Composable RowScope.() -> Unit = {},
    image: @Composable ((Modifier) -> Unit)? = null,
) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleView(title, image)
        navigateUp?.let {
            BackButtonView(
                navigateUp = navigateUp,
                hasImage = image != null,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Row(
            modifier = Modifier.align(Alignment.TopEnd).padding(vertical = 8.dp),
            content = toolbar
        )
    }

}

@Composable
@Suppress("FunctionName")
private fun BoxScope.TitleView(
    title: String,
    image: @Composable ((Modifier) -> Unit)?,
) {
    image?.let {
        var sizeImage by remember { mutableStateOf(IntSize.Zero) }

        val gradient = Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color(0x80000000)),
            startY = sizeImage.height.toFloat() / 2,
            endY = sizeImage.height.toFloat()
        )

        Box(
            contentAlignment = Alignment.BottomStart,
        ) {
            image(
                Modifier
                    .fillMaxWidth()
                    .height(196.dp)
                    .onGloballyPositioned {
                        sizeImage = it.size
                    }
            )
            Box(modifier = Modifier.matchParentSize().background(gradient))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    } ?: run {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 40.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 8.dp)
                .height(40.dp)
        )
    }
}

@Composable
@Suppress("FunctionName")
fun BoxScope.BackButtonView(
    navigateUp: () -> Unit,
    hasImage: Boolean,
    modifier: Modifier = Modifier,
) {
    DefaultNavigationBarButton(
        navigateUp,
        hasImage,
        modifier = modifier.align(Alignment.TopStart)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(Res.string.back),
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview
@Composable
@Suppress("FunctionName")
fun DefaultNavigationBarPreview() {
    DefaultNavigationBar(
        title = "Title",
        navigateUp = {},
        toolbar = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(Res.drawable.latexcards),
                    contentDescription = stringResource(Res.string.latexcards),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(Res.drawable.latexcards),
                    contentDescription = stringResource(Res.string.latexcards),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

@Preview
@Composable
@Suppress("FunctionName")
fun DefaultNavigationBarImagePreview() {
    DefaultNavigationBar(
        title = "Title",
        navigateUp = {},
        image = {
            Image(
                painter = painterResource(Res.drawable.latexcards),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = it
            )
        }
    )
}
