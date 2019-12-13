package com.axiaworks.toda.feature.qiitaclient

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface QiitaClientService {
    @GET("/api/v2/tags/{tag}/items?page=1&per_page=30")
    fun getItemsByTag(@Path("tag") tag: String): Observable<List<QiitaInfo>>
    @GET("/api/v2/items/{itemId}")
    fun getArticleByItemId(@Path("itemId") itemId:String): Observable<QiitaInfo>
}