package com.axiaworks.toda.feature.glide

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {
    companion object {
        const val imageURL = "https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg"
        const val imageURL2 = "https://contents.oricon.co.jp/special/img/52000/52822/detail/img480/1554804245661.jpg"
        const val imageURL3 = "https://s.aolcdn.com/hss/storage/midas/ab3657e22f040a9f99ce0e3f5de3231b/203475401/honda.jpg"
        fun callingIntent(context: Context) = Intent(context, GlideActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        Glide.with(imageView1)
            .load(imageURL)
            .error(R.mipmap.ic_launcher)
            .into(imageView1)

        Glide.with(imageView2)
            .load(imageURL2)
            .error(R.mipmap.ic_launcher)
            .into(imageView2)

        Glide.with(imageView3)
            .load(imageURL3)
            .error(R.mipmap.ic_launcher)
            .into(imageView3)

        Glide.with(imageView4)
            .load("")
            .error(R.mipmap.ic_launcher)
            .into(imageView4)

        // 角丸加工
        Glide.with(imageView5)
            .load(imageURL)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .error(R.mipmap.ic_launcher)
            .into(imageView5)

        // ぼかし加工
        Glide.with(imageView6)
            .load(imageURL)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
            .error(R.mipmap.ic_launcher)
            .into(imageView6)

        // トゥーン加工
        Glide.with(imageView7)
            .load(imageURL)
            .apply(RequestOptions.bitmapTransform(ToonFilterTransformation(10.0f, 5.0f)))
            .error(R.mipmap.ic_launcher)
            .into(imageView7)

        // コントラスト加工
        Glide.with(imageView8)
            .load(imageURL)
            .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(ContrastFilterTransformation(1.8f)))
            .into(imageView8)
    }
}
