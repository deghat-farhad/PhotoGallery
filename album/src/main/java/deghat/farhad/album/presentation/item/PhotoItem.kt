package deghat.farhad.album.presentation.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoItem(
    val url: String,
    val creationDate: String
) : Parcelable
