package cn.githink.mine.service

import cn.githink.mine.data.entity.UserInfo
import rx.Observable

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-22 9:39
 */
interface UserService {

    fun login(username:String,password:String):Observable<UserInfo>

    fun register(username: String,password: String,verifyCode:String):Observable<Boolean>
}