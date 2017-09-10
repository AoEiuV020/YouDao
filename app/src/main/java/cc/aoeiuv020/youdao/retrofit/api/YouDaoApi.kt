package cc.aoeiuv020.youdao.retrofit.api

import cc.aoeiuv020.youdao.retrofit.entity.TranslationJsonBean
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 有道翻译api,
 * retrofit管理，
 * Created by AoEiuV020 on 2017.09.10-17:31:30.
 */
interface YouDaoApi {
    companion object {
        val BASE_URL = "http://fanyi.youdao.com"
        fun create(): YouDaoApi = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YouDaoApi::class.java)
    }

    @GET("/openapi.do?keyfrom=wufeifei&key=716426270&type=data&doctype=json&version=1.1")
    fun getTranslation(@Query("q") query: String): Observable<TranslationJsonBean>
}