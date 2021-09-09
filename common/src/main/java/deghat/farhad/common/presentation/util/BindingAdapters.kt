package deghat.farhad.common.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import deghat.farhad.common.R


@BindingAdapter("bind:resizedImageUrl")
fun loadResizedImage(view: ImageView, imageUrl: String?) {
    loadImage(view, "$imageUrl?w=${view.width}&m=bb")
}

@BindingAdapter("bind:imageUrl")
fun loadToImageView(view: ImageView, imageUrl: String?) {
    loadImage(view, imageUrl)
}

private fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.with(view.context)
        .load(imageUrl)
        .networkPolicy(NetworkPolicy.OFFLINE)
        .into(view, object : Callback {
            override fun onSuccess() {}
            override fun onError() {
                Picasso.with(view.context)
                    .load(imageUrl)
                    .error(R.drawable.img_error_plaseholder)
                    .into(view)
            }
        })

}
