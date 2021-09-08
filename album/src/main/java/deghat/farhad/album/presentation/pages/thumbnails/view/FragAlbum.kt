package deghat.farhad.album.presentation.pages.thumbnails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import deghat.farhad.album.BR
import deghat.farhad.album.R
import deghat.farhad.album.presentation.pages.thumbnails.view_model.ViwMdlAlbum
import deghat.farhad.common.presentation.util.recycler_view.GenericRecyclerAdapter

@AndroidEntryPoint
class FragAlbum : Fragment() {
    private val viewModel: ViwMdlAlbum by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getOutOfFullScreenMode()
        setObservers()
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

    private fun setObservers() {
        viewModel.thumbnails.observe(viewLifecycleOwner) {
            val recViwThumbnails =
                requireActivity().findViewById<RecyclerView>(R.id.recViwThumbnails)
            val adapterThumbnail = GenericRecyclerAdapter(it) { parent, viewId ->
                RecHldrThumbnail.from(parent, viewId)
            }
            val lytMngrThumbnail = StaggeredGridLayoutManager(
                3,
                StaggeredGridLayoutManager.VERTICAL
            )

            recViwThumbnails.apply {
                layoutManager = lytMngrThumbnail
                adapter = adapterThumbnail
            }
        }

        viewModel.navigateToFullScreen.observe(viewLifecycleOwner) {
            val action = FragAlbumDirections.actionFragAlbumToFragFullScreen(it)
            findNavController().navigate(action)
        }
    }

    private fun getOutOfFullScreenMode() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}