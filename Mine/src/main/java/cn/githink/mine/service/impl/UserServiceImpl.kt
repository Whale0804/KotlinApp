package cn.githink.mine.service.impl

import cn.githink.common.ext.convert
import cn.githink.common.ext.convertBoolean
import cn.githink.mine.data.entity.UserInfo
import cn.githink.mine.data.repository.UserRepository
import cn.githink.mine.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-22 9:40
 */
class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun login(username: String, password: String): Observable<UserInfo> {
        return repository.login(username, password).convert()
    }

    override fun register(username: String, password: String, verifyCode: String): Observable<Boolean> {
        return repository.register(username,password,verifyCode).convertBoolean()
    }

}