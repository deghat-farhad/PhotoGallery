package deghat.farhad.album.presentation.pages.thumbnails.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import deghat.farhad.album.domain.model.Photo
import deghat.farhad.album.domain.usecase.GetPhotos
import deghat.farhad.album.domain.usecase.InvalidateAndRefreshCache
import deghat.farhad.album.presentation.item.PhotoItem
import deghat.farhad.album.presentation.item.RecItmThumbnail
import deghat.farhad.album.presentation.mapper.ThumbnailItemMapper
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import deghat.farhad.common.presentation.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class ViwMdlAlbum @Inject constructor(
    private val getPhotos: GetPhotos,
    private val thumbnailItemMapper: ThumbnailItemMapper,
    private val invalidateAndRefreshCache: InvalidateAndRefreshCache
) : ViewModel() {
    val thumbnails by lazy { MutableLiveData<List<RecItmThumbnail>>() }
    val navigateToFullScreen by lazy { SingleLiveEvent<PhotoItem>() }
    val statusMessage by lazy { MutableLiveData<String>() }
    val showStatusMessage by lazy { MutableLiveData<Boolean>() }
    val errors by lazy { SingleLiveEvent<String>() }
    val showTryAgainButton by lazy { MutableLiveData<Boolean>() }

    init {
        getPhotos()
    }

    private fun getPhotos() {
        showLoading()
        getPhotos.execute(viewModelScope, Unit) {
            handlePhotoModelWrapper(it)
        }
    }

    private fun showLoading() {
        statusMessage.postValue("loading...")
        showStatusMessage.postValue(true)
        showTryAgainButton.postValue(false)
    }

    private fun showError(message: String, error: String?) {
        statusMessage.postValue(message)
        showStatusMessage.postValue(true)
        showTryAgainButton.postValue(true)
        errors.postValue(error)
    }

    private fun showList() {
        showStatusMessage.postValue(false)
        showTryAgainButton.postValue(false)
    }

    fun retry() {
        getPhotos()
    }

    fun invalidateAndRefreshCache() {
        showLoading()
        invalidateAndRefreshCache.execute(viewModelScope, Unit) {
            handlePhotoModelWrapper(it)
        }
    }

    private fun handlePhotoModelWrapper(it: ModelWrapper<List<Photo>>) {
        when (it) {
            is ModelWrapper.NetworkError -> showError(
                "check your network connection and try again please.",
                it.error.message
            )
            is ModelWrapper.ServerError -> showError(
                "something's wrong with the server, contact the server administrator and try again please.",
                it.message.joinToString("\n")
            )
            is ModelWrapper.Success -> {
                showList()
                thumbnails.postValue(it.model.map { photo ->
                    thumbnailItemMapper.mapToPresentation(
                        photo
                    ) { photoItem ->
                        navigateToFullScreen.postValue(photoItem)
                    }
                })
            }
            is ModelWrapper.UnknownError -> showError(
                "something went wrong, try again later please.",
                it.error.message
            )
        }
    }
}