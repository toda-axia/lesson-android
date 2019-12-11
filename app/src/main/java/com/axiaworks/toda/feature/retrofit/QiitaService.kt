package com.axiaworks.toda.feature.retrofit

import com.axiaworks.toda.feature.qiitaclient.QiitaInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface QiitaService {

    @GET("/api/v2/tags/{tag}/items?page=1&per_page=30")
    // Retrofit課題を有効にする場合はしたの1行を有効化
    //fun getItemsByTag(@Path("tag") tag: String): Observable<ResponseBody>

    // Retrofit課題を有効にする場合はコメントアウト
    fun getItemsByTag(@Path("tag") tag: String): Observable<List<QiitaInfo>>
    @GET("/api/v2/items/{itemId}")
    fun getArticleByItemId(@Path("itemId") itemId:String): Observable<QiitaInfo>
}
