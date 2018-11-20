package cn.githink.common.rx

import cn.githink.common.presenter.view.AppView
import rx.Subscriber

/**
 * 订阅者通用实现
 */
open class BaseSubscriber<T>(val v:AppView):Subscriber<T>() {
    override fun onError(e: Throwable?) {
        v.hideLoading()
        if (e is BaseExecption){
            v.onError(e.msg)
        }
    }

    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        v.hideLoading()
    }
}