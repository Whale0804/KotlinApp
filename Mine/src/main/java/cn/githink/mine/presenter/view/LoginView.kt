package cn.githink.mine.presenter.view

import cn.githink.common.presenter.view.AppView
import cn.githink.mine.data.entity.UserInfo


/**
 * 描述: login view
 * @author Think
 * @create 2018-10-22 9:32
 */
interface LoginView: AppView {

    /**
     * 登录回调
     */
    fun loginResult(result: UserInfo)
}