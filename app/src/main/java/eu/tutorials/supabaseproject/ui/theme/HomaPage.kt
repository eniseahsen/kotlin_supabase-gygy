package eu.tutorials.supabaseproject.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import eu.tutorials.supabaseproject.navigation.Screen
import eu.tutorials.supabaseproject.viewmodel.TodoListViewModel
import kotlin.error

@Composable
fun Homepage(viewModel: TodoListViewModel,
             navController: NavController
){
    val todos by viewModel.todos.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.Add.route)
                }
            ) {
                Text("+")
            }
        }
    ){
        padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            when{
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){CircularProgressIndicator()}
                }
                error != null -> Text("Hata: $error")
                else -> ToDoList(
                    toDoList = todos,
                    onDelete = {viewModel.delete(it)})
            }

        }
    }


}