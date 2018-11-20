package cn.githink.common.utils

import android.content.Context

/**
 * 描述: 全局工具类
 * @author Think
 * @create 2018-10-19 15:58
 */
object AppUtils {

    fun dp2px(dp:Float, mContext:Context):Int {
        val scale = mContext.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

}