package com.axiaworks.toda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.feature.viewpager.ViewPager2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment_button.setOnClickListener {
            val intent = Intent(this, ViewPager2Activity::class.java)
            startActivity(intent)
        }
    }
}
