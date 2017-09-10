package cc.aoeiuv020.youdao.dagger.module

import cc.aoeiuv020.youdao.dagger.entity.Translation
import com.google.gson.Gson
import com.google.gson.JsonObject
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Singleton

/**
 * 调用有道api得到翻译，
 * 简单粗暴的调用和解析，
 * Created by AoEiuV020 on 2017.09.07-21:43:30.
 */
@Module
class YouDaoModule(val word: String) {
    // https://github.com/wufeifei/dict/blob/master/dict/__init__.py#L44
    private val YOU_DAO_URL = "http://fanyi.youdao.com/openapi.do?keyfrom=wufeifei&key=716426270&type=data&doctype=json&version=1.1&q="

    @Provides
    @Singleton
    fun translation(): Translation {
        var tran = ""
        var phonetic = ""
        var explains = ""
        var json = ""
        try {
            json = OkHttpClient.Builder().build()
                    .newCall(Request.Builder().url(YOU_DAO_URL + word).build())
                    .execute()
                    .body()!!.string()
            val root = Gson().fromJson(json, JsonObject::class.java)
            tran = root.getAsJsonArray("translation")
                    .joinToString(", ")
            val basic = root
                    .getAsJsonObject("basic")
            explains = basic.getAsJsonArray("explains")
                    .joinToString("\n")
            val us = basic.getAsJsonPrimitive("us-phonetic").asString
            val uk = basic.getAsJsonPrimitive("uk-phonetic").asString
            phonetic = "英 [$uk]  美 [$us]"
        } catch (_: Exception) {
            if (tran.isEmpty()) {
                explains = json
            }
        }
        return Translation(tran, phonetic, explains)
    }

    @Provides
    @Singleton
    fun translationObservable() = Observable.create<Translation> {
        it.onNext(translation())
    }
}

