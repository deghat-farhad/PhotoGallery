package deghat.farhad.album.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViwMdlAlbum @Inject constructor() : ViewModel() {
    val strBindingTest by lazy { MutableLiveData<String>("hello!") }

    init {
        viewModelScope.launch {
            delay(2000L)
            strBindingTest.postValue("I'm the album fragment.")
        }
    }
}