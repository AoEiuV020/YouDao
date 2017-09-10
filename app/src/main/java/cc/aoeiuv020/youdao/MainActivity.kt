package cc.aoeiuv020.youdao

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import cc.aoeiuv020.youdao.dagger.component.DaggerYouDaoComponent
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener {
            val listener = DaggerYouDaoComponent.builder()
                    .youDaoModule(YouDaoModule("${word.text}"))
                    .build()
                    .getTranslationLiveData()
            listener.observeForever { translation ->
                translation!!
                tran.text = translation.tran
                phonetic.text = translation.phonetic
                explains.text = translation.explains
            }
        }
    }
}

