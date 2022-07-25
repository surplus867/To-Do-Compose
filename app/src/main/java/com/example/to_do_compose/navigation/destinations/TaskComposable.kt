package com.example.to_do_compose.navigation.destinations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do_compose.ui.screens.task.TaskScreen
import com.example.to_do_compose.util.Action
import com.example.to_do_compose.util.Constants
import com.example.to_do_compose.util.Constants.TASK_ARGUMENT_KEY
import com.example.to_do_compose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){ navBacksStateEntry ->
        val taskId = navBacksStateEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", taskId.toString())

        TaskScreen(navigateToListScreen = navigateToListScreen )
    }
}