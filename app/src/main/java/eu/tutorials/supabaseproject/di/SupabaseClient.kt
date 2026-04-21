package eu.tutorials.supabaseproject.di

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient{
    val client = createSupabaseClient(
        supabaseKey = "sb_publishable_Xspkx7NCoUxdOq95oJNjWw_N0mWO_XD",
        supabaseUrl = "https://gpdpesjcmosdtwbahyup.supabase.co"
    ){
        install(Postgrest)
    }
}