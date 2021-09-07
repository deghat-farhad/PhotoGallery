package deghat.farhad.album.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import deghat.farhad.album.data.repository.RepoPhotoImpl
import deghat.farhad.album.domain.repository.RepoPhoto

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun repoPhoto(repoPhotoImpl: RepoPhotoImpl): RepoPhoto
}