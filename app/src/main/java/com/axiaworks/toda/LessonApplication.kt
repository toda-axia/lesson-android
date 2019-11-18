package com.axiaworks.toda

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader

class LessonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initFlipper()
    }

    private fun initFlipper() {
        SoLoader.init(
            this,
            false
        )
        if (FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).apply {
                addPlugin(
                    InspectorFlipperPlugin(
                        this@LessonApplication,
                        DescriptorMapping.withDefaults()
                    )
                )
                addPlugin(
                    SharedPreferencesFlipperPlugin(
                        this@LessonApplication,
                        "PrefFile"
                    )
                )
            }.start()
        }
    }
}