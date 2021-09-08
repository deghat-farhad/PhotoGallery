package deghat.farhad.album.presentation.pages.full_screen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import deghat.farhad.album.BR
import deghat.farhad.album.R
import deghat.farhad.album.presentation.pages.full_screen.view_model.ViwMdlFullScreen

@AndroidEntryPoint
class FragFullScreen : Fragment() {
    private val viewModel: ViwMdlFullScreen by viewModels()

    private val args: FragFullScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        goFullScreen()
        viewModel.setPhotoItem(args.photoItem)
        return setDataBinding(inflater, container)
    }

    private fun setDataBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        return DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.frag_full_screen,
            container,
            false
        ).apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@FragFullScreen
        }.root
    }

    private fun goFullScreen() {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}