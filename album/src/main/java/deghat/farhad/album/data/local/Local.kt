package deghat.farhad.album.data.local

import android.app.Application
import deghat.farhad.album.data.entity.PhotoEntity
import java.io.File
import javax.inject.Inject

class Local @Inject constructor(
    private val photoDatabase: PhotoDatabase,
    private val applicationContext: Application
) {
    suspend fun getPhotos(): List<PhotoEntity> {
        return photoDatabase.photoEntityDao.getPhotos()
    }

    suspend fun storePhotos(photoEntityList: List<PhotoEntity>) {
        photoDatabase.photoEntityDao.insertPhotos(photoEntityList)
    }

    suspend fun removePhotos() {
        photoDatabase.photoEntityDao.deletePhotos()
        val cache = File(applicationContext.cacheDir, "picasso-cache")
        if (cache.exists() && cache.isDirectory) {
            cache.listFiles()?.forEach { it.delete() }
        }
    }
}