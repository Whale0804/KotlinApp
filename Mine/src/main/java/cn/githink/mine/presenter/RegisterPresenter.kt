package cn.githink.mine.presenter

import cn.githink.common.ext.execute
import cn.githink.common.presenter.AppPresenter
import cn.githink.common.rx.BaseSubscriber
import cn.githink.mine.presenter.view.RegisterView
import cn.githink.mine.service.UserService
import com.zyao89.view.zloading.Z_TYPE
import javax.inject.Inject

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-22 9:30
 */
class RegisterPresenter@Inject constructor(): AppPresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(username:String, pwd: String,verifyCode:String){
        if (!checkNetWork()) {
            return
        }
        mView.showLoading(Z_TYPE.STAIRS_PATH)
        userService.register(username,pwd,verifyCode).execute(object : BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if(t){
                    mView.onRegisterResult("注册成功")
                }
            }
        },lifecycleProvider)
    }
}