package deghat.farhad.album.data.entity

import java.util.*

data class PhotoEntity(
    val size: Long?,
    val created_at: Date?,
    val thumbnail_url: String,
    val download_url: String
)
