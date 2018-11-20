package cn.githink.common.injection.component

import android.app.Activity
import android.content.Context
import cn.githink.common.injection.module.ActivityModule
import cn.githink.common.injection.module.LifecycleProviderModule
import cn.githink.common.injection.scope.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Activity级别Component
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
    modules = arrayOf(ActivityModule::class, LifecycleProviderModule::class))
interface ActivityComponent {
    /**
     * Component管理Inject标注的构造函数的Activity
     */
    fun activity(): Activity

    /**
     * Component管理Inject标注的构造函数的Context
     */
    fun context(): Context

    /**
     * Component管理Inject标注的构造函数的生命周期管理器
     */
    fun lifecycleProvider(): LifecycleProvider<*>
}