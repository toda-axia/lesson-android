package com.axiaworks.toda.feature.retrofit

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface QiitaService {
    @GET("/api/v2/tags/{tag}/items?page=1&per_page=30")
    fun getItemsByTag(@Path("tag") tag: String): Observable<ResponseBody>
}
