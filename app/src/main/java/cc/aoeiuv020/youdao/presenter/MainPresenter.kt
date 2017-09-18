package cc.aoeiuv020.youdao.presenter

import android.util.Log
import cc.aoeiuv020.youdao.App
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import cc.aoeiuv020.youdao.ui.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * presenter,
 * Created by AoEiuV020 on 2017.09.18-15:12:09.
 */
class MainPresenter(private val view: MainActivity) {
    fun requestTranslation(word: String) {
        App.component.plus(YouDaoModule(word))
                .getTranslationObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ translation ->
                    view.showResult(translation)
                }, { e ->
                    val message = "查询失败"
                    Log.e(MainActivity::class.java.simpleName, message, e)
                    view.showError(message)
                })
    }
}