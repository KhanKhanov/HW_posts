import java.time.LocalDateTime

interface Attachment {
    val type: String
}

data class AudioAttachment(
    val audioId: Long,       // идентификатор вложения
    val ownerId: Long,  // идентификатор владельца видео или аудио
    val title: String,  // название вложения
    val description: String,    // описание вложения
    val duration: Int,      // длительность вложения (аудио или видео)
    val date: LocalDateTime = LocalDateTime.now(),  // дата создания вложения (присваивается текущая)
    override val type: String = "Audio"
) : Attachment

data class VideoAttachment(
    val videoId: Long,       // идентификатор вложения
    val ownerId: Long,  // идентификатор владельца видео или аудио
    val title: String,  // название вложения
    val description: String,    // описание вложения
    val duration: Int,      // длительность вложения (аудио или видео)
    val date: LocalDateTime = LocalDateTime.now(),  // дата создания вложения (присваивается текущая)
    override val type: String = "Video"
) : Attachment