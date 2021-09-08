package deghat.farhad.album.presentation.item

import deghat.farhad.album.R
import deghat.farhad.common.presentation.util.recycler_view.Visitable

sealed class RecItmThumbnail : Visitable {
    data class Thumbnail(
        val url: String,
        val size: String
    ) : RecItmThumbnail() {
        override fun type() = R.layout.itm_thumbnail
    }
}
