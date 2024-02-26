import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

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

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val service = WallService
        val newPost = Post(text = "New post")
        val addPost = service.add(newPost)
        assertNotEquals(0, addPost.id)
    }

    @Test
    fun updatePostTrue() {
        val service = WallService
        service.add(Post(id = 1, text = "Second post"))
        service.add(Post(id = 2, text = "Third post"))
        service.add(Post(id = 3, text = "Fourth post"))

        val updPost = Post(id = 3, text = "Обновленная запись", likes = Likes(count = 4))
        val updatePost = service.update(updPost)
        assertTrue(updatePost)
    }

    @Test
    fun updatePostFalse() {
        val service = WallService
        service.add(Post(id = 1, text = "Second post"))
        service.add(Post(id = 2, text = "Third post"))
        service.add(Post(id = 3, text = "Fourth post"))

        val updPost = Post(id = 4, text = "Обновленная запись", likes = Likes(count = 4))
        val updatePost = service.update(updPost)
        assertFalse(updatePost)
    }
}