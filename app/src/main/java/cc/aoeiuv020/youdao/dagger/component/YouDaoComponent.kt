package cc.aoeiuv020.youdao.dagger.component

import cc.aoeiuv020.youdao.dagger.entity.Translation
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import dagger.Subcomponent
import io.reactivex.Observable

/**
 * 自动生成实际使用的DaggerYouDaoComponent类，
 * 联系module类，充许的module都写在modules里，
 * Created by AoEiuV020 on 2017.09.07-20:43:24.
 */
@Subcomponent(modules = arrayOf(YouDaoModule::class))
interface YouDaoComponent {
    fun getTranslationObservable(): Observable<Translation>
}