package cc.aoeiuv020.youdao.retrofit.entity

import com.google.gson.annotations.SerializedName

/**
 * 接收json的bean类，
 * Created by AoEiuV020 on 2017.09.10-17:48:59.
 */
data class TranslationJsonBean(
        var translation: List<String>,
        var basic: Basic,
        var query: String, // hello
        var errorCode: Int, // 0
        var web: List<Web>
)

data class Web(
        var value: List<String>,
        var key: String// Hello
)

data class Basic(
        @SerializedName("us-phonetic") var us_phonetic: String?, // həˈlo
        @SerializedName("uk-phonetic") var uk_phonetic: String?, // həˈləʊ
        var phonetic: String, // həˈləʊ
        var explains: List<String>
)