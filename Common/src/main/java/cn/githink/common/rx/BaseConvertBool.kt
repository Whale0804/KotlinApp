package cn.githink.common.rx

import cn.githink.common.http.entity.Think
import com.githink.common.common.ResultCode
import rx.Observable
import rx.functions.Func1

/**
 * 对bool类型数据的通用处理
 */
class BaseConvertBool<T>:Func1<Think<T>,Observable<Boolean>>{
    override fun call(t: Think<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseExecption(t.status,t.message))
        }
        return Observable.just(true)

    }
}