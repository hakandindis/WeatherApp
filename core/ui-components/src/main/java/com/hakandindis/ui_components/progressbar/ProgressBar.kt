package com.hakandindis.ui_components.progressbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * CREATED BY hakandindis on 2.06.2024
 */


@Composable
fun ProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(

        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun ProgressBarPreview() {
    ProgressBar()
}