package eu.tutorials.supabaseproject.repository

import eu.tutorials.supabaseproject.di.SupabaseClient
import eu.tutorials.supabaseproject.model.Todo
import io.github.jan.supabase.postgrest.from

class TodoRepository {
    suspend fun getTodos(): List<Todo>{
        return SupabaseClient.client.from("todos").select().decodeList<Todo>()
    }

    suspend fun deleteTodo(id: Int){
        SupabaseClient.client.from("todos")
            .delete { filter{ eq("id", id)} }
    }

    suspend fun addTodo(todo: Todo){
        SupabaseClient.client.from("todos").insert(todo)
    }
}