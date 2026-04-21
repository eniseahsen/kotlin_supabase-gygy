package eu.tutorials.supabaseproject.ui.theme

import android.R.attr.description
import android.R.attr.title
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.tutorials.supabaseproject.viewmodel.TodoListViewModel

@Composable
fun AddTodoScreen(
    viewModel: TodoListViewModel,
    navController: NavController
) {

    var title by remember { mutableStateOf("") }
    var description by remember {mutableStateOf("")}

    Column(modifier = Modifier.padding(16.dp)) {

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Başlık") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = description,
            onValueChange = {description = it},
            label = {Text("Açıklama")}
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            viewModel.add(title, description)
            navController.popBackStack() // geri Home
        }) {
            Text("Ekle")
        }
    }
}