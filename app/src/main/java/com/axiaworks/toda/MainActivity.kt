package com.axiaworks.toda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.axiaworks.toda.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment_button.setOnClickListener {
//            val intent = Intent(this, FragmentsActivity::class.java).apply {
//                putExtra(EXTRA_MESSAGE)
//            }
            val intent = Intent(this, FragmentsActivity::class.java)
            startActivity(intent)
        }
    }
}
