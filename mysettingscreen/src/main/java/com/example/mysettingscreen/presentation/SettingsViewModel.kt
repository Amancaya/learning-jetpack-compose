package com.example.mysettingscreen.presentation

import androidx.lifecycle.ViewModel
import com.example.mysettingscreen.model.MarketingOption
import com.example.mysettingscreen.model.SettingsState
import com.example.mysettingscreen.ui.theme.Theme
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel: ViewModel() {
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings() {
        uiState.value = uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintSettings() {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun setMarketingSettings(option: MarketingOption) {
        uiState.value = uiState.value.copy(marketingOption = option)
    }

    fun setTheme(theme: Theme) {
        uiState.value = uiState.value.copy(themeOption = theme)
    }
}