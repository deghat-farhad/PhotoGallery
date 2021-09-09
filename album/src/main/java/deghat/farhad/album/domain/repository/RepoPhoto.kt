package deghat.farhad.album.domain.repository

import deghat.farhad.album.domain.model.Photo
import deghat.farhad.common.domain.usecase.base.ModelWrapper

interface RepoPhoto {
    suspend fun getPhotos(): ModelWrapper<List<Photo>>
    suspend fun invalidateAndRefreshCache(): ModelWrapper<List<Photo>>
}