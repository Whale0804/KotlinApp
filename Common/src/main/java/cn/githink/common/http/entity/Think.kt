package cn.githink.common.http.entity

/**
 * 通用数据返回实现
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
class Think<out T>(val status:Int, val message:String, val data:T)