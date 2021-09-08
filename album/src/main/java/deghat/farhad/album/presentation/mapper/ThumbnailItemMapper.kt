package deghat.farhad.album.presentation.mapper

import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.presentation.item.RecItmThumbnail
import javax.inject.Inject
import kotlin.math.pow

class ThumbnailItemMapper @Inject constructor() {
    fun mapToPresentation(from: Photo) = RecItmThumbnail.Thumbnail(
        from.thumbnail.url ?: "",
        if (from.thumbnail.size == null)
            "---"
        else
            "${"%.2f".format(bytesToMegaBytes(from.thumbnail.size))}MB"
    )

    private fun bytesToMegaBytes(bytes: Long) = bytes / 1024f.pow(2)
}