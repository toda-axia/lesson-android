package com.axiaworks.toda

import android.app.Application
import com.axiaworks.toda.feature.qiitaclient.QiitaClientViewModel
import com.axiaworks.toda.feature.retrofit.QiitaService
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.squareup.moshi.Moshi
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class LessonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initFlipper()
        setupKoin()
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

    private fun setupKoin() {
        val module: Module = module{
            viewModel{
                QiitaClientViewModel()
            }
            single {
                createRetrofitService("https://qiita.com", QiitaService::class.java)
            }
        }
        startKoin(this, listOf(module))
    }

    private fun <T> createRetrofitService(baseUrl: String, service: Class<T>): T =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .build()
            .create(service)
}