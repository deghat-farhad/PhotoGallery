package deghat.farhad.album.data.local

import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.album.data.mapper.PhotoMapper
import deghat.farhad.album.data.remote.Remote
import deghat.farhad.album.domain.model.Photo
import deghat.farhad.common.data.mapper.NetworkResponseMapper
import deghat.farhad.common.data.utils.network.NetworkResponse
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import javax.inject.Inject

class Cache @Inject constructor(
    private val local: Local,
    private val remote: Remote,
    private val photoMapper: PhotoMapper,
    private val photoNetworkResponseMapper: NetworkResponseMapper<List<PhotoEntity>, List<Photo>>
) {
    suspend fun getPhotos(): ModelWrapper<List<Photo>> {
        val localPhotos = local.getPhotos()
        return if (localPhotos.isNotEmpty()) {
            ModelWrapper.Success(photoMapper.mapToDomain(localPhotos))
        } else {
            val remotePhotos = remote.getPhotos()
            if (remotePhotos is NetworkResponse.Success)
                local.storePhotos(remotePhotos.body)
            photoNetworkResponseMapper.mapToDomain(
                remotePhotos,
                photoMapper
            )
        }
    }
}