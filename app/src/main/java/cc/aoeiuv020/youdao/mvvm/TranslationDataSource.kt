package cc.aoeiuv020.youdao.mvvm

import io.reactivex.Observable

/**
 *
 * Created by AoEiuV020 on 2017.11.15-16:04:35.
 */
interface TranslationDataSource {
    fun search(word: String): Observable<TranslationData>
}