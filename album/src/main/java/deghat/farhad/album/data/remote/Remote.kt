package deghat.farhad.album.data.remote

import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.common.data.entity.ErrorResponse
import deghat.farhad.common.data.utils.network.NetworkResponse
import javax.inject.Inject

class Remote @Inject constructor(
    private val serviceGenerator: ServiceGenerator
) {
    suspend fun getPhotos(): NetworkResponse<List<PhotoEntity>, ErrorResponse> {
        return serviceGenerator.photoService().getPhotos()
    }
}