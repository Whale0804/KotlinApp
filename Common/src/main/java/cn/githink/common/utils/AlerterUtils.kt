package cn.githink.common.utils

import android.app.Activity
import cn.githink.common.R
import com.tapadoo.alerter.Alerter

/**
 * 描述: Alerter封装
 * @author Think
 * @create 2018-10-24 12:09
 */
object AlerterUtils {

    fun error(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_error_bg)
            .setIcon(R.drawable.alert_error_icon)
            .show()
    }

    fun success(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_success_bg)
            .setIcon(R.drawable.alert_success_icon)
            .show()
    }

    fun warn(activity: Activity,title: String,message: String){
        Alerter.create(activity)
            .setTitle(title)
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(10000)
            .setBackgroundColorRes(R.color.alert_warn_bg)
            .setIcon(R.drawable.alert_warn_icon)
            .show()
    }
}