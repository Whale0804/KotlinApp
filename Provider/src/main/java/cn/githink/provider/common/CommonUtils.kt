package cn.githink.provider.common

import cn.githink.common.common.Constant
import cn.githink.common.utils.AppPrefsUtils
import cn.githink.provider.router.RouterPath
import com.alibaba.android.arouter.launcher.ARouter

/*
    顶级函数，判断是否登录
 */
fun isLogined():Boolean{
    return AppPrefsUtils.getString(Constant.KEY_SP_TOKEN).isNotEmpty()
}

/*
    如果已经登录，进行传入的方法处理
    如果没有登录，进入登录界面
 */
fun afterLogin(method:()->Unit){
    if (isLogined()){
        method()
    }else{
        ARouter.getInstance().build(RouterPath.MineModule.LOGIN_PATH).navigation()
    }
}
