package cn.githink.common

import android.app.Application
import android.content.Context
import cn.githink.common.injection.component.AppComponent
import cn.githink.common.injection.component.DaggerAppComponent
import cn.githink.common.injection.module.AppModule
import com.alibaba.android.arouter.launcher.ARouter

class App:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInJection()

        context = this

        //ARouter初始化
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)

    }

    private fun initAppInJection() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    /*
        全局伴生对象
     */
    companion object {
        lateinit var context: Context
    }
}