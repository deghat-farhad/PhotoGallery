package deghat.farhad.album.data.remote

import deghat.farhad.album.data.remote.service.PhotoService
import retrofit2.Retrofit
import javax.inject.Inject

class ServiceGenerator @Inject constructor(private val retrofit: Retrofit) {
    fun photoService() = retrofit.create(PhotoService::class.java)
}