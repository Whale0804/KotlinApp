package cn.githink.kotlinapp.injection.module


import cn.githink.kotlinapp.service.MainService
import cn.githink.kotlinapp.service.impl.MainServiceImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providesMainService(service: MainServiceImpl): MainService {
        return service
    }
}