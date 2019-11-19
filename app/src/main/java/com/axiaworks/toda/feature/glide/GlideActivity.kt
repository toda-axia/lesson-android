package com.axiaworks.toda.feature.glide

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, GlideActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        Glide.with(imageView1)
            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView1)

        Glide.with(imageView2)
            .load("https://contents.oricon.co.jp/special/img/52000/52822/detail/img480/1554804245661.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView2)

        Glide.with(imageView3)
            .load("https://s.aolcdn.com/hss/storage/midas/ab3657e22f040a9f99ce0e3f5de3231b/203475401/honda.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView3)

        Glide.with(imageView4)
            .load("")
            .error(R.mipmap.ic_launcher)
            .into(imageView4)

        // 角丸加工
        Glide.with(imageView5)
            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .error(R.mipmap.ic_launcher)
            .into(imageView5)

        Glide.with(imageView6)
            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView6)

        Glide.with(imageView7)
            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView7)

        Glide.with(imageView8)
            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
            .error(R.mipmap.ic_launcher)
            .into(imageView8)
    }
}
