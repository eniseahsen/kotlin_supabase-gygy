package eu.tutorials.supabaseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.tutorials.supabaseproject.navigation.Screen
import eu.tutorials.supabaseproject.ui.theme.AddTodoScreen
import eu.tutorials.supabaseproject.ui.theme.Homepage
import eu.tutorials.supabaseproject.ui.theme.SupabaseprojectTheme
import eu.tutorials.supabaseproject.ui.theme.TodoScreen
import eu.tutorials.supabaseproject.viewmodel.TodoListViewModel
import kotlinx.coroutines.flow.combine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Scaffold { paddingValues ->
                AppNavigation(
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}
@Composable
fun AppNavigation(modifier: Modifier= Modifier) {
    val navController = rememberNavController()
    val viewModel: TodoListViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            Homepage(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(Screen.Add.route) {
            AddTodoScreen(
                viewModel = viewModel,
                navController = navController
            )

        }
    }
}