package deghat.farhad.album.data.repository

import deghat.farhad.album.data.remote.Remote
import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.domain.repository.RepoPhoto
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import javax.inject.Inject

class RepoPhotoImpl @Inject constructor(
    private val remote: Remote
) : RepoPhoto {
    override suspend fun getPhotos(): ModelWrapper<List<Photo>> {
        return remote.getPhotos()
    }
}