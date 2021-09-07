package deghat.farhad.album.domain.usecase

import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.domain.repository.RepoPhoto
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import deghat.farhad.common.domain.usecase.base.UseCase
import kotlin.coroutines.CoroutineContext

class GetPhotos(
    coroutineContext: CoroutineContext,
    private val repository: RepoPhoto
) : UseCase<List<Photo>, Unit>(
    coroutineContext
) {
    override suspend fun buildUseCase(params: Unit): ModelWrapper<List<Photo>> {
        return repository.getPhotos()
    }
}