package cn.githink.mine.presenter


import cn.githink.common.presenter.AppPresenter
import cn.githink.common.rx.BaseSubscriber
import cn.githink.mine.data.entity.UserInfo
import cn.githink.mine.presenter.view.LoginView
import com.zyao89.view.zloading.Z_TYPE
import javax.inject.Inject

/**
 * 描述: 登录presenter
 * @author Think
 * @create 2018-10-22 9:30
 */
class LoginPresenter@Inject constructor(): AppPresenter<LoginView>() {

    fun login(username:String,password:String){
        if (!checkNetWork()) {
            return
        }
        mView.showLoading(Z_TYPE.SNAKE_CIRCLE)

    }
}