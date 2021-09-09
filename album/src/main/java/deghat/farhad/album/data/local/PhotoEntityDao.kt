package deghat.farhad.album.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import deghat.farhad.album.data.entity.PhotoEntity

@Dao
interface PhotoEntityDao {
    @Insert
    suspend fun insertPhotos(photoEntityList: List<PhotoEntity>)

    @Query("DELETE FROM photoentity")
    suspend fun deletePhotos()

    @Query("SELECT * FROM photoentity")
    suspend fun getPhotos(): List<PhotoEntity>
}