package deghat.farhad.album.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import deghat.farhad.album.R
import deghat.farhad.album.presentation.viewmodel.ViwMdlAlbum

@AndroidEntryPoint
class FragAlbum : Fragment() {
    val viewModel: ViwMdlAlbum by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_album, container, false)
    }
}