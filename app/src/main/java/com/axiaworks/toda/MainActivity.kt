package com.axiaworks.toda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.feature.dialog_fragment.DialogFragmentActivity
import com.axiaworks.toda.feature.dialog_fragment2.DialogFragment2Activity
import com.axiaworks.toda.feature.glide.GlideActivity
import com.axiaworks.toda.feature.firebase.FirebaseAnalyticsActivity
import com.axiaworks.toda.feature.viewpager.ViewPager2Activity
import com.axiaworks.toda.feature.recyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment_button.setOnClickListener {
            startActivity(ViewPager2Activity.callingIntent(this))
        }

        recycler_view_button.setOnClickListener {
            startActivity(RecyclerViewActivity.callingIntent(this))
        }

        glide_button.setOnClickListener {
            startActivity(GlideActivity.callingIntent(this))
        }

        firebase_analytics_button.setOnClickListener {
            startActivity(FirebaseAnalyticsActivity.callingIntent(this))
        }

        dialogfragment_button.setOnClickListener {
            startActivity(DialogFragmentActivity.callingIntent(this))
        }

        dialogfragment2_button.setOnClickListener {
            startActivity(DialogFragment2Activity.callingIntent(this))
        }
    }
}
