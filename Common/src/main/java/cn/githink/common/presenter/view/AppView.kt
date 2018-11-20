package cn.githink.common.presenter.view

import com.zyao89.view.zloading.Z_TYPE

interface AppView {

    /**
     * 显示加载框
     */
    fun showLoading(TYPE: Z_TYPE)

    /**
     * 隐藏加载框
     */
    fun hideLoading()

    /**
     * 错误回调
     */
    fun onError(message: String)
}