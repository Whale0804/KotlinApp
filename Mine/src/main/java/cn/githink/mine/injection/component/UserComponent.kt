package cn.githink.mine.injection.component

import cn.githink.common.injection.component.ActivityComponent
import cn.githink.mine.presenter.activity.LoginActivity
import cn.githink.common.injection.scope.PreComponentScope
import cn.githink.mine.injection.module.UserModule
import cn.githink.mine.presenter.activity.RegisterActivity
import dagger.Component

@PreComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
    modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: LoginActivity)
    fun inject(activity: RegisterActivity)
}