package com.example.to_do_compose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_do_compose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
           TaskAppBar(navigateToListScreen = navigateToListScreen )

        },
        content = {}
    )

}