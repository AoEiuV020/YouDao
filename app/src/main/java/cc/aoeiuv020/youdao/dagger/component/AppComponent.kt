package cc.aoeiuv020.youdao.dagger.component

import android.content.Context
import cc.aoeiuv020.youdao.dagger.module.AppModule
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import dagger.Component

/**
 * 提供context和subcomponent,
 * Created by AoEiuV020 on 2017.09.13-19:59:48.
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    val ctx: Context

    fun plus(module: YouDaoModule): YouDaoComponent
}
