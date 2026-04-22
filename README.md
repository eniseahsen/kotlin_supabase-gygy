## Supabase Todo App (Jetpack Compose + MVVM)

### [SupabaseClient](app/src/main/java/eu/tutorials/supabaseproject/di/SupabaseClient.kt)
- Supabase ile bağlantı kurar
- PostgREST modülünü aktif eder
- Tüm proje boyunca tek bir client kullanılır (singleton)

### [Todo Model](app/src/main/java/eu/tutorials/supabaseproject/model/Todo.kt)
- Veri modelini tanımlar
- JSON ↔ Kotlin dönüşümünü sağlar
- Supabase “todos” tablosunu temsil eder

### [Navigation -> Sccren.kt](app/src/main/java/eu/tutorials/supabaseproject/model/Todo.kt)
- 
