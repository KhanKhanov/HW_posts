interface Attachment {
    val type: String
}

data class AudioAttachment(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int,
    override val type: String = "Audio"
) : Attachment


data class VideoAttachment(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int,
    override val type: String = "Video"
) : Attachment