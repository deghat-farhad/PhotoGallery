package deghat.farhad.album.presentation.mapper

import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.presentation.item.PhotoItem
import deghat.farhad.album.presentation.item.RecItmThumbnail
import java.text.DateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.pow

class ThumbnailItemMapper @Inject constructor() {
    companion object {
        const val DATE_FORMAT = "MMMM yyyy"
    }

    fun mapToPresentation(from: Photo): RecItmThumbnail.Thumbnail {
        val format = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        return RecItmThumbnail.Thumbnail(
            from.thumbnail.url ?: "",
            if (from.thumbnail.size == null)
                "---"
            else
                "${"%.2f".format(bytesToMegaBytes(from.thumbnail.size))}MB",
            PhotoItem(
                from.fullScreen.url ?: "",
                from.fullScreen.creationDate?.let {
                    format.format(it)
                } ?: "---"
            )
        ) {}
    }

    private fun bytesToMegaBytes(bytes: Long) = bytes / 1024f.pow(2)
}