package cn.githink.common.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import cn.githink.common.R
import cn.githink.common.ext.loadUrl
import cn.githink.common.ext.onClick
import kotlinx.android.synthetic.main.app_toolbar_layout.view.*

/**
 * 描述: ${DESCRIPTION}
 * @author Think
 * @create 2018-10-26 14:17
 */
class AppToolBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): FrameLayout(context,attrs, defStyleAttr){
    init {
        initView()
    }
    private fun initView(){
        View.inflate(context, R.layout.app_toolbar_layout,this)
    }

    //设置标题
    fun setTitle(title:String){
        mAppTitle.text = title
    }

    //设置网络头像
    fun setAvatarOnInternet(url:String){
        mUserAvatar.loadUrl(url)
    }

    //设置本地头像
    fun setAvatarOnLocal(url:Int){
        mUserAvatar.setImageResource(url)
    }

    //点击头像展开侧滑菜单
    fun onClickMineInfoListen(method: ()->Unit){
        mMineInfo.onClick { method() }
    }

    //设置左侧第一个Icon按钮
    fun setIcon1(icon:Int){
        mToolBarIcon1.setImageResource(icon)
    }
    fun setIcon1WidthAndHeight(width:Int,height:Int){
        mToolBarIcon1.getLayoutParams().height=width
        mToolBarIcon1.getLayoutParams().width=height
    }

    fun setIcon1Visible(visible:Int){
        mToolBarIcon1.visibility=visible
    }

    fun onClickIcon1Listen(method: () -> Unit){
        mToolBarIcon1.onClick { method() }
    }

    //设置左侧第二个Icon按钮
    fun setIcon2(icon:Int){
        mToolBarIcon2.setImageResource(icon)
    }
    fun setIcon2WidthAndHeight(width:Int,height:Int){
        mToolBarIcon2.getLayoutParams().height=width
        mToolBarIcon2.getLayoutParams().width=height
    }

    fun setIcon2Visible(visible:Int){
        mToolBarIcon2.visibility=visible
    }

    fun onClickIcon2Listen(method: () -> Unit){
        mToolBarIcon2.onClick { method() }
    }

    //设置左侧第三个Icon按钮
    fun setIcon3(icon:Int){
        mToolBarIcon3.setImageResource(icon)
    }
    fun setIcon3WidthAndHeight(width:Int,height:Int){
        mToolBarIcon3.layoutParams.height=width
        mToolBarIcon3.layoutParams.width=height
    }

    fun setIcon3Visible(visible:Int){
        mToolBarIcon3.visibility=visible
    }

    fun onClickIcon3Listen(method: () -> Unit){
        mToolBarIcon3.onClick { method() }
    }

    fun setToolBarColor(color:Int){
        AppToolBar.setBackgroundColor(color)
    }

    fun setToolBarHeight(height: Int){
        AppToolBar.layoutParams.height=height
    }
}