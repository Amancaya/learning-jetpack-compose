/*
 * Copyright 2021 Compose Academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package academy.compose.inbox.ui

import academy.compose.inbox.InboxViewModel
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalMaterialApi
@Composable
fun Inbox() {
    val viewModel: InboxViewModel = viewModel()
    MaterialTheme {
        EmailInbox(
            inboxState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
    LaunchedEffect(Unit) {
        viewModel.loadContent()
    }
}