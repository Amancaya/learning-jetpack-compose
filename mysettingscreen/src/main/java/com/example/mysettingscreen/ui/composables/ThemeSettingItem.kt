package com.example.mysettingscreen.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue // { mutableStateOf(default) } produce error -> https://stackoverflow.com/questions/64951605/var-value-by-remember-mutablestateofdefault-produce-error-why
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mysettingscreen.R
import com.example.mysettingscreen.ui.theme.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onOptionSelected: (option: Theme) -> Unit
) {
    SettingItem {
        var expanded by remember { mutableStateOf(false) }

        Row(
            modifier =  Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme),
            )
            Text(text = stringResource(id = selectedTheme.label))
        }
        
        DropdownMenu(expanded = expanded, onDismissRequest = { /*TODO*/ }) {
            
        }
    }
}