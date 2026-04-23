## Supabase Todo App (Jetpack Compose + MVVM)

### [SupabaseClient](app/src/main/java/eu/tutorials/supabaseproject/di/SupabaseClient.kt)
- Supabase ile bağlantı kurar
- PostgREST modülünü aktif eder
- Tüm proje boyunca tek bir client kullanılır (singleton)

### [Todo Model](app/src/main/java/eu/tutorials/supabaseproject/model/Todo.kt)
- Veri modelini tanımlar
- JSON ↔ Kotlin dönüşümünü sağlar
- Supabase “todos” tablosunu temsil eder

### [Navigation](app/src/main/java/eu/tutorials/supabaseproject/navigation/Screen.kt)
- Navigation Compose route yönetimi sağlar
- Home ve Add ekranlarını tanımlar

### [TodoRepository](app/src/main/java/eu/tutorials/supabaseproject/repository/TodoRepository.kt)
- Supabase ile veri alışverişi yapar 
- Supabase sorgularını yönetir (listeleme, silme, ekleme)

### [View Model](app/src/main/java/eu/tutorials/supabaseproject/viewmodel/TodoListViewModel.kt)
- Repository’den veri çeker
- UI state’i yönetir
- Loading & error durumlarını kontrol eder

### [Home Page](app/src/main/java/eu/tutorials/supabaseproject/ui/theme/HomaPage.kt)
- Todo listesini gösterir
- FloatingActionButton ile Add ekranına gider

### [Add Todo Page](app/src/main/java/eu/tutorials/supabaseproject/ui/theme/AddTodo.kt)
- Kullanıcıdan title + description alır
- ViewModel üzerinden Supabase’e gönderir
- Kayıttan sonra geri Home ekranına döner
  
### [Todo List](app/src/main/java/eu/tutorials/supabaseproject/ui/theme/TodoList.kt)
- Todo listesini ekranda gösterir
- Her item için: ID, Title, Description gösterir
- Silme butonu içerir

### [Todo Screen](app/src/main/java/eu/tutorials/supabaseproject/ui/theme/ToDoScreen.kt)
- ViewModel’den veri çeker
- LazyColumn ile liste gösterir

### [Main Activity](app/src/main/java/eu/tutorials/supabaseproject/MainActivity.kt)
- Navigation Graph oluşturur
- ViewModel’i paylaşır
- Home ve Add ekranlarını bağlar
