package cn.githink.mine.data.api

import cn.githink.common.http.entity.Think
import cn.githink.mine.data.entity.LoginRequest
import cn.githink.mine.data.entity.RegisterRequest
import cn.githink.mine.data.entity.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/*
    用户相关 接口
 */
interface UserApi{


    /*
        用户登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginRequest):Observable<Think<UserInfo>>

    /*
        用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterRequest):Observable<Think<String>>


}
