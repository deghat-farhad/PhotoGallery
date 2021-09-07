package deghat.farhad.album.data.mapper

import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.domain.model.Thumbnail
import deghat.farhad.common.data.mapper.MapperToDomain
import javax.inject.Inject

class PhotoMapper @Inject constructor() : MapperToDomain<List<PhotoEntity>, List<Photo>> {
    private fun mapPhotoToDomain(from: PhotoEntity): Photo {
        return Photo(Thumbnail(from.thumbnail_url, from.size))
    }

    override fun mapToDomain(from: List<PhotoEntity>): List<Photo> {
        return from.map { mapPhotoToDomain(it) }
    }
}