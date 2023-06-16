package com.example.androidlearningproject.ch1_box_layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BoxLayoutExample(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Text(text = "Im at top",
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.TopCenter)
            )

        Text(text = "Im at center but at side",
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterEnd)
            )
        
        Text(text = "Im at bottom",
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.BottomCenter)
            )

    }

}


@Preview
@Composable
fun BoxInNight() {
    BoxLayoutExample()
}

@Preview(locale = "ar")
@Composable
fun BoxInArabic() {
    BoxLayoutExample()
}