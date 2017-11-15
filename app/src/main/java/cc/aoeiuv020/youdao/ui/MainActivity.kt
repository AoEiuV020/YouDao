package cc.aoeiuv020.youdao.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cc.aoeiuv020.youdao.R
import cc.aoeiuv020.youdao.databinding.ActivityMainBinding
import cc.aoeiuv020.youdao.mvvm.TranslationData

class MainActivity : AppCompatActivity() {
    private val translationData = TranslationData()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.translation = translationData
    }
}

