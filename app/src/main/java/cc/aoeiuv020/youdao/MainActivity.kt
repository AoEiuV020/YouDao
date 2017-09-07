package cc.aoeiuv020.youdao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cc.aoeiuv020.youdao.dagger.component.DaggerYouDaoComponent
import cc.aoeiuv020.youdao.dagger.entity.Translation
import cc.aoeiuv020.youdao.dagger.module.HelloModule
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /*
    调用inject方法时自动给这个translation赋值，
     */
    @Inject lateinit var translation: Translation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener {
            doAsync {
                DaggerYouDaoComponent.builder()
                        .youDaoModule(YouDaoModule("${word.text}"))
                        .build()
                        .inject(this@MainActivity)
                uiThread {
                    phonetic.text = translation.phonetic
                    explains.text = translation.explains
                }
            }
        }
    }
}
