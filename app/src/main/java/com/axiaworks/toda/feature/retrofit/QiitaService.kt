package com.axiaworks.toda.feature.retrofit

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://qiita.com/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface QiitaService {
    @GET("/api/v2/tags/{tag}/items?page=1&per_page=3")
    fun getItemsByTag(@Path("tag") user: String): Observable<ResponseBody>
}
