package eu.tutorials.supabaseproject.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.supabaseproject.repository.TodoRepository
import eu.tutorials.supabaseproject.model.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoListViewModel: ViewModel() {
    private val repository = TodoRepository()
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow();

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    init{
        fetchTodos()
    }

    fun fetchTodos(){
        viewModelScope.launch{
            _isLoading.value = true
            try{
                _todos.value = repository.getTodos()
                _error.value = null
            }
            catch (e: Exception){
                _error.value = e.message
            }
            finally {
                _isLoading.value = false
            }

        }
    }

    fun delete(id: Int){
        viewModelScope.launch {
            try{
                repository.deleteTodo(id)
                fetchTodos()
            }
            catch (e: Exception){
                _error.value = e.message
            }
        }
    }

    fun add(title: String, description: String?){
        viewModelScope.launch {
            try{
                val newTodo = Todo(
                    title = title,
                    description = description
                )
                repository.addTodo(newTodo)
                fetchTodos()

            }
            catch (e: Exception){
                _error.value = e.message
            }
        }
    }


}