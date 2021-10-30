package deghat.farhad.album.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import deghat.farhad.album.domain.repository.RepoPhoto
import deghat.farhad.album.domain.usecase.GetPhotos
import deghat.farhad.album.domain.usecase.InvalidateAndRefreshCache
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun getPhotos(
        repoPhoto: RepoPhoto
    ) = GetPhotos(
        repoPhoto
    )

    @Provides
    fun invalidateAndRefreshCache(
        repoPhoto: RepoPhoto
    ) = InvalidateAndRefreshCache(
        repoPhoto
    )
}