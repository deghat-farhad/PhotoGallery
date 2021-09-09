package deghat.farhad.photomoto

import android.app.Application
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PhotoMotoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val builder: Picasso.Builder =
            Picasso.Builder(this)
        builder.downloader(OkHttpDownloader(this, Long.MAX_VALUE))
        val built: Picasso = builder.build()
        Picasso.setSingletonInstance(built)
    }
}