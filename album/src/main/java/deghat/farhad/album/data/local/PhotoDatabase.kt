package deghat.farhad.album.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.common.data.utils.persistent.DateConverter

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class PhotoDatabase : RoomDatabase() {
    abstract val photoEntityDao: PhotoEntityDao
}