package cn.githink.provider.utils

import android.view.View
import android.widget.TextView
import cn.githink.common.common.UserConstant
import cn.githink.common.ext.loadUrl
import cn.githink.common.utils.AppPrefsUtils
import cn.githink.common.widgets.AppToolBar
import cn.githink.provider.R
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.find

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-29 13:39
 */
object UserUtils {

    fun loadUser(header: View, mAppToolBar: AppToolBar){
        var avatar = header.find<CircleImageView>(R.id.mAvatar)
        var username = header.find<TextView>(R.id.mUsername)
        var mail = header.find<TextView>(R.id.mMail)
        val userAvatar = AppPrefsUtils.getString(UserConstant.KEY_SP_USER_ICON)
        if (userAvatar.isNotEmpty()) {
            avatar.loadUrl(userAvatar)
        }
        username.text = "hello"
        mail.text = "xxx@gmail.com"
        mAppToolBar.setAvatarOnInternet(userAvatar)
    }
}