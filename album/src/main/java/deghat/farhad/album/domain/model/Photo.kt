package deghat.farhad.album.domain.model

import java.util.*

data class Photo(
    val thumbnail: Thumbnail,
    val fullScreen: FullScreen
)

data class Thumbnail(
    val url: String?,
    val size: Long?
)

data class FullScreen(
    val url: String?,
    val creationDate: Date?
)