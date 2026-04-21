package eu.tutorials.supabaseproject.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eu.tutorials.supabaseproject.model.Todo

@Composable
fun ToDoList(
    toDoList: List<Todo>,
    onDelete: (Int) -> Unit
)
{
    LazyColumn {
        items(toDoList){
            todo ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text("#${todo.id}")
                    Text(todo.title)
                    todo.description?.let {Text(it)}
                }
                IconButton(onClick = {todo.id?.let{onDelete(it)}}) {
                    Icon(Icons.Default.Close, contentDescription = "Sil")
                }
            }
        }
    }
}