package cn.githink.common.injection.component

import android.content.Context
import cn.githink.common.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * App 全局Component 主要是注入全局context
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}