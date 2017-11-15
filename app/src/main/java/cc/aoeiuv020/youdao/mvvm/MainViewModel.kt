package cc.aoeiuv020.youdao.mvvm

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.util.Log
import cc.aoeiuv020.youdao.ui.MainActivity
import io.reactivex.schedulers.Schedulers

/**
 *
 * Created by AoEiuV020 on 2017.11.15-15:36:56.
 */
class MainViewModel : ViewModel() {
    val data = Translation()
    private val source: TranslationDataSource = YouDaoDataSource()

    fun search() {
        source.search(data.word).subscribeOn(Schedulers.io()).subscribe({ translation ->
            data.tran = translation.tran
            data.phonetic = translation.phonetic
            data.explains = translation.explains
            data.notifyChange()
        }, { e ->
            val message = "查询失败"
            Log.e(MainActivity::class.java.simpleName, message, e)
            data.explains = message
            data.notifyChange()
        })
    }

    inner class Translation(
            var word: String = "",
            var tran: String = "",
            var phonetic: String = "",
            var explains: String = ""
    ) : BaseObservable() {
        fun onSearch() {
            search()
        }
    }
}