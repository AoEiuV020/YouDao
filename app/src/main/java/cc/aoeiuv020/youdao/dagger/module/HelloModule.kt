package cc.aoeiuv020.youdao.dagger.module

import cc.aoeiuv020.youdao.dagger.entity.Translation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * module负责获取数据相关业务逻辑，
 * Created by AoEiuV020 on 2017.09.07-21:09:51.
 */
@Module
class HelloModule(@Suppress("UNUSED_PARAMETER") word: String) {
    /*
     * 方法名任意，返回类型唯一，
     */
    @Provides
    @Singleton
    fun translation(): Translation =
            Translation("英 [həˈləʊ]  美 [həˈlo]",
                    """
            int. 喂；哈罗
            n. 表示问候， 惊奇或唤起注意时的用语
            n. (Hello)人名；(法)埃洛
            """.trimIndent())
}