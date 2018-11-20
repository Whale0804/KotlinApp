package cn.githink.mine.utils

import cn.githink.common.common.Constant
import cn.githink.common.common.UserConstant
import cn.githink.mine.data.entity.UserInfo
import cn.githink.common.utils.AppPrefsUtils

/*
    本地存储用户相关信息
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(Constant.KEY_SP_TOKEN, userInfo?.userName ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
        AppPrefsUtils.putString(UserConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
    }
}
