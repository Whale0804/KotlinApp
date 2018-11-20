package cn.githink.common.presenter

import android.content.Context
import cn.githink.common.presenter.view.AppView
import com.githink.common.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

open class AppPresenter<V:AppView> {

    lateinit var mView: V


    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    /*
        检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}