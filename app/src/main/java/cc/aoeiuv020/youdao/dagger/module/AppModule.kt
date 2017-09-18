package cc.aoeiuv020.youdao.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * 只有个context,
 * Created by AoEiuV020 on 2017.09.13-19:59:59.
 */
@Module
class AppModule(val ctx: Context) {
    @Provides
    fun ctx() = ctx
}