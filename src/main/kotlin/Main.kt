data class Post (
    val id: Int = 0, //идентификатор записи
    val fromId: Int = 0, // идентификатор автора записи (от чьего имени опубликована запись)
    val date: Int = 0, // время публикации записи
    val text: String = "", // текст записи
    val friendsOnly: Boolean = true, //true - если запись была создана с опцией "Только для друзей"
    val canPin: Boolean = true, // true - может ли текущий пользователь закрепить запись
    val canDelete: Boolean = true, // true - может ли текущий пользователь удалить запись
    val canEdit: Boolean = true, // true - может ли текущий пользователь редактировать запись
    val markedAsAds: Boolean = true, // true - информация о том, содержит ли запись отметку "реклама"
    val isFavorite: Boolean = true, // true - объект добавлен в закладки у текущего пользователя
    var comments: Comments = Comments(),
    var likes: Likes = Likes()
)

// другие data-classes, которые могут быть вложены в класс Post
data class Comments (
    val count: Int = 0, // количество комментариев
    val canPost: Boolean = true, // true- текущий пользователь может комментировать запись
    val groupsCanPost: Boolean = true, //true- сообщества могут комментировать запись
    val canClose: Boolean = true, // true - текущий пользователь может закрыть комментарии к записи
    val canOpen: Boolean = true //true - текущий пользователь может открыть комментарии к записи
)

data class Likes (
    val count: Int = 0, // число пользователей, которым понравилась запись
    val userLikes: Boolean = true,  //true - наличие отметки "Мне нравится" от текущего пользователя
    val canLike: Boolean = true, // true - может ли текущий пользователь поставить отметку "Мне нравится"
    val canPublish: Boolean = true // true - может ли текущий пользователь сделать репост записи
)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Int = 0

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId + 1)
        posts += newPost
        nextId++
        return newPost
    }

    fun update(post: Post): Boolean {
        for (i in posts.indices) {
            if (posts[i].id == post.id) {
                val updatedPost = posts[i].copy(text = post.text, likes = Likes(count = 60))
                posts[i] = updatedPost
                println(posts[i])
                return true
            }
        }
        return false
    }
}

fun main() {
    val postService = WallService
    val newPost = Post(text = "Новая запись", likes = Likes(count = 3))
    val addedPost = postService.add(newPost)
    println(addedPost)

    val newPost2 = Post(text = "Вторая новая запись")
    val addedPost2 = postService.add(newPost2)
    println(addedPost2)

    val updPost = Post(id = 2, text = "Обновленная запись поста", likes = Likes(count = 4))
    val updatePost = postService.update(updPost)
    println(updatePost)
}