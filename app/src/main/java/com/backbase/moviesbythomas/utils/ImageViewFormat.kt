package com.backbase.moviesbythomas.utils

import android.util.Log
import android.widget.ImageView
import com.backbase.moviesbythomas.R
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient

fun ImageView.loadImage(url: String, dimens: Pair<Int, Int>, quality: String = "185"){

    if(url.isNotEmpty()){

        val urlToSend = "${Constants.IMAGE_BASE_URL}w${quality}${url}?api_key=${Constants.API_KEY}"
        Log.v("Image--->",urlToSend)
        val imageView = this
        val okHttpClient = OkHttpClient()

        val picasso = Picasso.Builder(this.context).downloader(OkHttp3Downloader(okHttpClient)).build()
        picasso.load(urlToSend)
            .resize(dimens.first, dimens.second)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .centerCrop()
            .placeholder(R.drawable.default_poster)
            .error(R.drawable.default_poster)
            .into(this, object : Callback {
                override fun onSuccess() {
                    Log.v("PICASSO", "Seccess")
                }

                override fun onError(e: Exception?) {
                    Picasso.get().load(urlToSend)
                        .error(R.drawable.default_poster)
                        .into(imageView, object : Callback{
                            override fun onSuccess() {
                                Log.v("PICASSO", e?.localizedMessage ?: "")
                            }

                            override fun onError(e: java.lang.Exception?) {
                                Log.v("PICASSO", e?.localizedMessage ?: "")
                            }

                        })
                }
            })

    }

}