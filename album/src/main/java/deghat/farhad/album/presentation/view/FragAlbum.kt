package deghat.farhad.album.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import deghat.farhad.album.BR
import deghat.farhad.album.R
import deghat.farhad.album.presentation.view_model.ViwMdlAlbum

@AndroidEntryPoint
class FragAlbum : Fragment() {
    private val viewModel: ViwMdlAlbum by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setDataBinding(inflater, container)
    }

    private fun setDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        return DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.frag_album,
            container,
            false
        ).apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@FragAlbum
        }.root
    }
}