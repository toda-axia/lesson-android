package com.axiaworks.toda.feature.glide

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.viewpager.ViewPager2Activity

class GlideActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, GlideActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
    }
}
