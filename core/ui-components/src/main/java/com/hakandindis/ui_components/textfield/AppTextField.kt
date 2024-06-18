package com.hakandindis.ui_components.textfield

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * CREATED BY hakandindis on 1.05.2024
 */


@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = {
            Text("Enter your text")
        }
    )
}

@Preview
@Composable
internal fun AppTextFieldPreview() {
    AppTextField(value = "", onValueChange = {})
}