package cn.githink.kotlinapp.injection.component

import cn.githink.common.injection.component.ActivityComponent
import cn.githink.common.injection.scope.PreComponentScope
import cn.githink.kotlinapp.injection.module.MainModule
import cn.githink.kotlinapp.presenter.activity.MainActivity
import dagger.Component

@PreComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}