package cn.githink.mine.presenter.activity

import android.view.View
import cn.githink.common.ext.onClick
import cn.githink.common.ext.startTop
import cn.githink.common.presenter.activity.AppMvpActivity
import cn.githink.common.utils.AlerterUtils
import cn.githink.mine.R
import cn.githink.mine.injection.component.DaggerUserComponent
import cn.githink.mine.injection.module.UserModule
import cn.githink.mine.presenter.RegisterPresenter
import cn.githink.mine.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.input_register_layout.*
import org.jetbrains.anko.toast


class RegisterActivity : AppMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {
    override fun onRegisterResult(result: String) {
        toast("注册成功")
        startTop<LoginActivity>()
    }


    override fun initData() {

    }

    override fun initView(){
        mRegisterLayout.setBackgroundResource(R.drawable.login_bg)
        mMainTitle.getSignInBtn().onClick(this)
        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mSignInBtn ->{
                finish()
            }
            R.id.mRegisterBtn ->{
                if (mVerifyCodeEt.text.toString() == ""){
                    AlerterUtils.error(this,"消息通知","验证码不能为空！")
                }
                if (mPwdEt.text.toString() == "" || mRePwdEt.text.toString() == ""){
                    AlerterUtils.error(this,"消息通知","密码不能为空！")
                }
                if (mPwdEt.text.toString() != mRePwdEt.text.toString()){
                    AlerterUtils.warn(this,"消息通知","密码与确认密码不一致！")
                }
                mPresenter.register(mUserNameEt.text.toString(),mPwdEt.text.toString(),
                    mVerifyCodeEt.text.toString())
            }
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .userModule(UserModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun layoutId(): Int {
        return R.layout.activity_register
    }

}
