package deghat.farhad.album.data.remote.service

import deghat.farhad.album.data.entity.PhotoEntity
import deghat.farhad.common.data.entity.ErrorResponse
import deghat.farhad.common.data.utils.network.NetworkResponse
import retrofit2.http.GET

interface PhotoService {
    @GET("/shared/djlCbGusTJamg_ca4axEVw/media")
    suspend fun getPhotos(): NetworkResponse<List<PhotoEntity>, ErrorResponse>
}