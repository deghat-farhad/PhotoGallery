package deghat.farhad.album.domain.model

data class Photo(
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val url: String?,
    val size: Int?
)