package cc.aoeiuv020.youdao.dagger.component

import cc.aoeiuv020.youdao.MainActivity
import cc.aoeiuv020.youdao.dagger.module.HelloModule
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import dagger.Component
import javax.inject.Singleton

/**
 * 自动生成实际使用的DaggerYouDaoComponent类，
 * 联系module类，充许的module都写在modules里，
 * Created by AoEiuV020 on 2017.09.07-20:43:24.
 */
@Singleton
@Component(modules = arrayOf(YouDaoModule::class))
interface YouDaoComponent {
    fun inject(mainActivity: MainActivity)
}