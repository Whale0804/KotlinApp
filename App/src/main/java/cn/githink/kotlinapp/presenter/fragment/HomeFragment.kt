package cn.githink.kotlinapp.presenter.fragment

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.githink.common.presenter.fragment.AppFragment

import cn.githink.kotlinapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

class HomeFragment : AppFragment() {
    override fun mActivity(): Activity {
        return activity?.let{
            return it
        } as Activity
    }

    override fun getFragmentId(): Int = R.layout.fragment_home


    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * 初始化数据
     */
    override fun initData() {

    }

    /**
     * 初始化视图
     */
    override fun initView(){
        initToolBar()
    }

    /**
     * 初始化ToolBar
     */
    fun initToolBar(){
        //设置标题
        mAppToolBar.setTitle("KotlinX")
        //展开侧边栏
        mAppToolBar.onClickMineInfoListen {
            mActivity().mDrawerLayout.openDrawer(GravityCompat.START)
        }
        mAppToolBar.setIcon2Visible(View.VISIBLE)
        mAppToolBar.setIcon3Visible(View.VISIBLE)
        mAppToolBar.onClickIcon2Listen { toast("click 1") }
        mAppToolBar.onClickIcon3Listen { toast("click 2") }
    }

}
