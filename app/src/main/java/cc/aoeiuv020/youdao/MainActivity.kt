package cc.aoeiuv020.youdao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cc.aoeiuv020.youdao.dagger.component.DaggerYouDaoComponent
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener {
            doAsync {
                val translation = DaggerYouDaoComponent.builder()
                        .youDaoModule(YouDaoModule("${word.text}"))
                        .build()
                        .getTranslation()
                uiThread {
                    tran.text = translation.tran
                    phonetic.text = translation.phonetic
                    explains.text = translation.explains
                }
            }
        }
    }
}
