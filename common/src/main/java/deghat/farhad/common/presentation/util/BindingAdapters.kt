package deghat.farhad.common.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import deghat.farhad.common.R

@BindingAdapter("bind:resizedImageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.with(view.context)
        .load("$imageUrl?w=${view.width}&m=bb")
        .placeholder(R.drawable.img_placeholder)
        .error(R.drawable.img_error_plaseholder)
        .into(view)
}