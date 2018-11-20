package cn.githink.mine.injection.module



import cn.githink.mine.service.UserService
import cn.githink.mine.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 描述: 用户module
 * @author Think
 * @create 2018-10-22 9:37
 */
@Module
class UserModule  {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}