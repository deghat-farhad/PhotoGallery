package deghat.farhad.album.presentation.pages.thumbnails.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import deghat.farhad.album.presentation.item.RecItmThumbnail
import deghat.farhad.common.presentation.util.recycler_view.Holder
import deghat.farhad.common.presentation.util.recycler_view.Visitable

class RecHldrThumbnail(private val viewDataBinding: ViewDataBinding) : Holder(viewDataBinding) {

    companion object {
        fun from(parent: ViewGroup, viewId: Int): RecHldrThumbnail {
            val inflater = LayoutInflater.from(parent.context)
            val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                viewId,
                parent,
                false
            )
            return RecHldrThumbnail(viewDataBinding)
        }
    }

    override fun bind(item: Visitable) {
        when (item) {
            is RecItmThumbnail.Thumbnail -> viewDataBinding.setVariable(BR.item, item)
        }
    }
}