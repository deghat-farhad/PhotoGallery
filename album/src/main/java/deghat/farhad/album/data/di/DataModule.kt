package deghat.farhad.album.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import deghat.farhad.album.data.local.PhotoDatabase

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun photoDatabase(
        @ApplicationContext applicationContext: Context
    ): PhotoDatabase {
        return Room.databaseBuilder(
            applicationContext,
            PhotoDatabase::class.java, "database-name"
        ).build()
    }
}