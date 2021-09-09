package deghat.farhad.album.data.local

import deghat.farhad.album.data.entity.PhotoEntity
import javax.inject.Inject

class Local @Inject constructor(
    private val photoDatabase: PhotoDatabase
) {
    suspend fun getPhotos(): List<PhotoEntity> {
        return photoDatabase.photoEntityDao.getPhotos()
    }

    suspend fun storePhotos(photoEntityList: List<PhotoEntity>) {
        photoDatabase.photoEntityDao.insertPhotos(photoEntityList)
    }
}