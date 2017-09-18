package cc.aoeiuv020.youdao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cc.aoeiuv020.youdao.dagger.module.YouDaoModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search.setOnClickListener {
            App.component.plus(YouDaoModule("${word.text}"))
                    .getTranslationObservable()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ translation ->
                        tran.text = translation.tran
                        phonetic.text = translation.phonetic
                        explains.text = translation.explains
                    }, { error ->
                        Log.e(MainActivity::class.java.simpleName, "查询失败", error)
                        explains.text = "查询失败"
                    })
        }
    }
}

