package cn.githink.mine.data.repository

import cn.githink.common.http.HttpHelper
import cn.githink.common.http.entity.Think
import cn.githink.mine.data.api.UserApi
import cn.githink.mine.data.entity.LoginRequest
import cn.githink.mine.data.entity.RegisterRequest
import cn.githink.mine.data.entity.UserInfo
import rx.Observable
import javax.inject.Inject

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-22 9:53
 */
class UserRepository @Inject constructor() {

    /*
        用户登录
     */
    fun login(mobile:String,pwd:String): Observable<Think<UserInfo>> {
        return HttpHelper.instance.create(UserApi::class.java).login(LoginRequest(mobile,pwd))
    }

    /*
       用户注册
    */
    fun register(username:String,pwd:String,verifyCode:String):Observable<Think<String>>{
        return HttpHelper.instance.create(UserApi::class.java).register(RegisterRequest(username,pwd,verifyCode))
    }

}