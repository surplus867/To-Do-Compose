package com.example.to_do_compose.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.to_do_compose.data.models.Priority
import com.example.to_do_compose.data.models.ToDoTask
import com.example.to_do_compose.ui.viewmodels.SharedViewModel
import com.example.to_do_compose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

    Scaffold(
        topBar = {
           TaskAppBar(
               selectedTask = selectedTask,
               navigateToListScreen = { action ->
                   if (action == Action.NO_ACTION) {
                     navigateToListScreen(action)
                   } else {
                       if (sharedViewModel.validateFields()) {
                           navigateToListScreen(action)
                       } else {
                           displayToast(context = context)
                       }
                   }
               }
           )
        },
        content = {
            TaskContent(
                title = title ,
                onTitleChange = {
                    sharedViewModel.updateTitle(it)
                } ,
                description = description ,
                onDescriptionChange = {
                                      sharedViewModel.description.value = it
                },
                priority = priority ,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()
}
