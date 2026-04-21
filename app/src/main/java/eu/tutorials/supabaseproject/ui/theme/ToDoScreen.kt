package eu.tutorials.supabaseproject.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eu.tutorials.supabaseproject.viewmodel.TodoListViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState

@Composable
fun TodoScreen(viewModel: TodoListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    val todos = viewModel.todos.collectAsState().value
    LazyColumn {
        items(todos){
            todo ->
            Column(modifier = Modifier.padding(16.dp)){
                Text(text = todo.title)
                todo.description?.let{
                    Text(text = it)
                }
            }
        } }
}