package com.example.to_do_compose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_do_compose.data.models.ToDoTask
import com.example.to_do_compose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
           TaskAppBar(
               selectedTask = selectedTask,
               navigateToListScreen = navigateToListScreen )

        },
        content = {}
    )

}