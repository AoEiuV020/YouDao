package cc.aoeiuv020.youdao.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cc.aoeiuv020.youdao.R
import cc.aoeiuv020.youdao.dagger.entity.Translation
import cc.aoeiuv020.youdao.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        search.setOnClickListener {
            presenter.requestTranslation(word.text.toString())
        }
    }

    fun showResult(translation: Translation) {
        tran.text = translation.tran
        phonetic.text = translation.phonetic
        explains.text = translation.explains
    }

    fun showError(message: String) {
        explains.text = message
    }
}

