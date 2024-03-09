import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

// далее тесты, кода WallService - обычный класс

//class WallServiceTest {
//
//    @Test
//    fun addPost() {
//        val service = WallService()
//        val newPost = Post(text = "New post")
//        val addPost = service.add(newPost)
//        assertNotEquals(0, addPost.id)
//    }
//
//    @Test
//    fun updatePostTrue() {
//        val service = WallService()
//        service.add(Post(id = 1, text = "Second post"))
//        service.add(Post(id = 2, text = "Third post"))
//        service.add(Post(id = 3, text = "Fourth post"))
//
//        val updPost = Post(id = 3, text = "Обновленная запись", likes = Likes(count = 4))
//        val updatePost = service.update(updPost)
//        assertTrue(updatePost)
//    }
//
//    @Test
//    fun updatePostFalse() {
//        val service = WallService()
//        service.add(Post(id = 1, text = "Second post"))
//        service.add(Post(id = 2, text = "Third post"))
//        service.add(Post(id = 3, text = "Fourth post"))
//
//        val updPost = Post(id = 4, text = "Обновленная запись", likes = Likes(count = 4))
//        val updatePost = service.update(updPost)
//        assertFalse(updatePost)
//    }
//}


// ниже тесты, если WallService - object
class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val service = WallService
        val newPost = Post(text = "New post", attachments = emptyArray())
        val addPost = service.add(newPost)
        assertNotEquals(0, addPost.id)
    }

    @Test
    fun updatePostTrue() {
        val service = WallService
        service.add(Post(id = 1, text = "Second post", attachments = emptyArray()))
        service.add(Post(id = 2, text = "Third post", attachments = emptyArray()))
        service.add(Post(id = 3, text = "Fourth post", attachments = emptyArray()))

        val updPost = Post(id = 3, text = "Обновленная запись", likes = Likes(count = 4), attachments = emptyArray())
        val updatePost = service.update(updPost)
        assertTrue(updatePost)
    }

    @Test
    fun updatePostFalse() {
        val service = WallService
        service.add(Post(id = 1, text = "Second post", attachments = emptyArray()))
        service.add(Post(id = 2, text = "Third post", attachments = emptyArray()))
        service.add(Post(id = 3, text = "Fourth post", attachments = emptyArray()))

        val updPost = Post(id = 4, text = "Обновленная запись", likes = Likes(count = 4), attachments = emptyArray())
        val updatePost = service.update(updPost)
        assertFalse(updatePost)
    }
}