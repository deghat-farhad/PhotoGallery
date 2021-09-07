package deghat.farhad.album.data.remote

import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.album.data.mapper.PhotoMapper
import deghat.farhad.album.domain.model.Photo
import deghat.farhad.common.data.mapper.NetworkResponseMapper
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import javax.inject.Inject

class Remote @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val photoMapper: PhotoMapper,
    private val photoNetworkResponseMapper: NetworkResponseMapper<List<PhotoEntity>, List<Photo>>
) {
    suspend fun getPhotos(): ModelWrapper<List<Photo>> {
        return photoNetworkResponseMapper.mapToDomain(
            serviceGenerator.photoService().getPhotos(),
            photoMapper
        )
    }
}