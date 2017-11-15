package cc.aoeiuv020.youdao.mvvm

import cc.aoeiuv020.youdao.retrofit.api.YouDaoApi
import io.reactivex.Observable

/**
 *
 * Created by AoEiuV020 on 2017.11.15-16:04:25.
 */
class YouDaoDataSource : TranslationDataSource {
    // https://github.com/wufeifei/dict/blob/master/dict/__init__.py#L44
    private val YOU_DAO_URL = "http://fanyi.youdao.com/openapi.do?keyfrom=wufeifei&key=716426270&type=data&doctype=json&version=1.1&q="
    private val youDaoApi = YouDaoApi.create()

    override fun search(word: String): Observable<TranslationData> = youDaoApi.getTranslation(word).map {
        var tran = ""
        var phonetic = ""
        var explains = ""
        try {
            tran = it.translation.joinToString(", ")
            explains = it.basic.explains.joinToString("\n")
            val us = it.basic.us_phonetic
            val uk = it.basic.uk_phonetic
            if (us != null || uk != null) {
                phonetic = "英 [$uk]  美 [$us]"
            }
        } catch (_: Exception) {
            if (tran.isEmpty()) {
                tran = "查询无果"
            }
        }
        TranslationData(tran, phonetic, explains)
    }
}