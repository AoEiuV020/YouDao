package cc.aoeiuv020.youdao.dagger.entity

/**
 * 这个是这里通过dagger最终得到的东西，
 * 一个实体类，
 * Created by AoEiuV020 on 2017.09.07-21:00:40.
 */
data class Translation(val tran: String,
                       val phonetic: String = "",
                       val explains: String = "")