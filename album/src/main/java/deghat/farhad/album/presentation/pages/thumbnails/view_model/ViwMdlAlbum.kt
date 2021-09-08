package deghat.farhad.album.presentation.pages.thumbnails.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import deghat.farhad.album.domain.usecase.GetPhotos
import deghat.farhad.album.presentation.item.RecItmThumbnail
import deghat.farhad.album.presentation.mapper.ThumbnailItemMapper
import deghat.farhad.common.domain.usecase.base.ModelWrapper
import javax.inject.Inject

@HiltViewModel
class ViwMdlAlbum @Inject constructor(
    private val getPhotos: GetPhotos,
    private val thumbnailItemMapper: ThumbnailItemMapper
) : ViewModel() {
    val thumbnails by lazy { MutableLiveData<List<RecItmThumbnail>>() }

    init {
        getPhotos()
    }

    private fun getPhotos() {
        getPhotos.execute(viewModelScope, Unit) {
            when (it) {
                is ModelWrapper.NetworkError -> TODO()
                is ModelWrapper.ServerError -> TODO()
                is ModelWrapper.Success -> {
                    thumbnails.postValue(it.model.map { photo ->
                        thumbnailItemMapper.mapToPresentation(
                            photo
                        )
                    })
                }
                is ModelWrapper.UnknownError -> TODO()
            }
        }
    }
}