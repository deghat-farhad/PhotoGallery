package deghat.farhad.album.presentation.pages.full_screen.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import deghat.farhad.album.presentation.item.PhotoItem
import javax.inject.Inject

@HiltViewModel
class ViwMdlFullScreen @Inject constructor() : ViewModel() {
    val photoItem by lazy { MutableLiveData<PhotoItem>() }

    fun setPhotoItem(photoItem: PhotoItem) {
        this.photoItem.postValue(photoItem)
    }
}