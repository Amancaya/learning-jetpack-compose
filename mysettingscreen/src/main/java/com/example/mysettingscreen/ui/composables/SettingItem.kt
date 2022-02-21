package com.example.mysettingscreen.ui.composables

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingItem (
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Surface( // It will theme itself use the surface color from the application theme
        modifier = modifier
            .heightIn(min = 56.dp) //will have a height of at least 56.dp, does not enforce a fixed size
    ) {
        content()
    }
}
