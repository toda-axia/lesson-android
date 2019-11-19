package com.axiaworks.toda.feature.glide

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.viewpager.ViewPager2Activity
import com.bumptech.glide.Glide
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
            .into(imageView1)

        Glide.with(imageView2)
            .load("https://contents.oricon.co.jp/special/img/52000/52822/detail/img480/1554804245661.jpg")
            .into(imageView2)
//
//        Glide.with(imageView3)
//            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg\thttps://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
//            .into(imageView3)
//
//        Glide.with(imageView4)
//            .load("https://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg\thttps://cdn.narinari.com/site_img/photox/201909/23/20190922038.jpg")
//            .into(imageView4)
    }
}
