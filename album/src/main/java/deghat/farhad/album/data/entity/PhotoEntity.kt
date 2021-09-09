package deghat.farhad.album.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class PhotoEntity(
    @PrimaryKey
    val id: String,
    val size: Long?,
    val created_at: Date?,
    val thumbnail_url: String,
    val download_url: String
)
