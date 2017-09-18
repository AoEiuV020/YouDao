package cc.aoeiuv020.youdao

import android.app.Application
import cc.aoeiuv020.youdao.dagger.component.AppComponent
import cc.aoeiuv020.youdao.dagger.component.DaggerAppComponent
import cc.aoeiuv020.youdao.dagger.module.AppModule

/**
 * 提供全局component,
 * Created by AoEiuV020 on 2017.09.13-19:59:07.
 */

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        App.component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
