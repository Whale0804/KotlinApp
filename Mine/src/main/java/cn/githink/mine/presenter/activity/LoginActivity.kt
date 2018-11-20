package cn.githink.mine.presenter.activity

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import cn.githink.common.common.AppManager
import cn.githink.common.ext.onClick
import cn.githink.common.presenter.activity.AppMvpActivity
import cn.githink.mine.data.entity.UserInfo
import cn.githink.mine.presenter.LoginPresenter
import cn.githink.mine.presenter.view.LoginView
import cn.githink.common.utils.AlerterUtils
import cn.githink.mine.R
import cn.githink.mine.injection.component.DaggerUserComponent
import cn.githink.mine.injection.module.UserModule
import cn.githink.mine.utils.UserPrefsUtils
import cn.githink.provider.router.RouterPath
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.input_login_layout.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

@Route(path = RouterPath.MineModule.LOGIN_PATH)
class LoginActivity : AppMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {
    private var mForgetPwdBtn: TextView? = null

    override fun initData() {

    }

    override fun initView(){
        mLoginLayout.setBackgroundResource(R.drawable.login_bg)
        mForgetPwdBtn = find(R.id.mForgetPwdBtn)
        mForgetPwdBtn!!.paint.isAntiAlias = true //去掉锯齿
        mForgetPwdBtn!!.paint.flags = Paint.UNDERLINE_TEXT_FLAG //添加下划线

        //登录
        mLoginBtn.onClick(this)
        //注册
        mTitleLayout.getSignInBtn().onClick(this)
        //忘记密码
        mForgetPwdBtn!!.onClick(this)

    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.mSignInBtn ->{

            }
            R.id.mForgetPwdBtn ->{
                toast("忘记密码")
            }
            R.id.mLoginBtn ->{
                if (mUserNameEt.text.toString() == "" || mPwdEt.text.toString() == ""){
                    AlerterUtils.error(this,"消息通知","用户名或密码不能为空！")
                    return
                }
                /**
                 * 登录方法
                 */
                mPresenter.login(mUserNameEt.text.toString(),mPwdEt.text.toString())

            }
        }
    }

    /**
     * 登录回调
     */
    override fun loginResult(result: UserInfo) {
        toast("登录成功")
        //保存用户信息
        UserPrefsUtils.putUserInfo(result)
        finish()
    }

    /**
     * 初始化依赖注入
     */
    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }


    override fun onBackPressed() {
        AppManager.instance.finishActivity(this)
    }
}
