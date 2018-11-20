package cn.githink.common.rx

import cn.githink.common.http.entity.Think
import com.githink.common.common.ResultCode
import rx.Observable
import rx.functions.Func1

/**
 * 通用数据处理
 */
class BaseConvert<T>:Func1<Think<T>,Observable<T>>{
    override fun call(t: Think<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseExecption(t.status,t.message))
        }
        return Observable.just(t.data)

    }
}