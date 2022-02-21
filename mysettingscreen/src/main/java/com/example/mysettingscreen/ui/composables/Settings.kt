package com.example.mysettingscreen.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mysettingscreen.R
import com.example.mysettingscreen.model.SettingsState
import com.example.mysettingscreen.presentation.SettingsViewModel


@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()

    //Wrapping your composable hierarchy in a theme allows all components to be consistently styled
    MaterialTheme {
        val state = viewModel.uiState.collectAsState().value
    }
}

//@Preview(showBackground = true)
@Composable
fun SettingsList(
    modifier: Modifier = Modifier, //It’s good practice to allow a modifier to be passed into a composable
    viewModel: SettingsViewModel,
    state: SettingsState
){
    Column(modifier = modifier.verticalScroll( rememberScrollState())) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface, //It is possible to use direct Color references when overriding color values, such as Color.White
            contentPadding = PaddingValues(start = 12.dp) //the PaddingValues class applies paddingin the same way that you would do using the Padding modifier
        ) {
            Icon(
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back)
            )
            Spacer(modifier = Modifier.width(16.dp)) //The Spacer can be seen as a blank composable area
            Text(
                text = stringResource(id = R.string.title_settings),
                fontSize = 18.sp, //It’s important to use sp for any values that are related to font sizes
                color = MaterialTheme.colors.onSurface
            )
        }
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_enable_notifications),
            checked = state.notificationsEnabled,
            onToggleNotificationSettings = viewModel::toggleNotificationSettings
        )
        Divider()
        HintSettingsItem(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_show_hints),
            checked = state.hintsEnabled,
            onShowHintsToggled = viewModel::toggleHintSettings
        )
    }
}