package cn.githink.kotlinapp.presenter.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.View
import cn.githink.common.presenter.fragment.AppFragment
import cn.githink.kotlinapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mine.*


class MineFragment : AppFragment() {
    private lateinit var headerlayout: View

    override fun mActivity(): Activity {
        return activity?.let{
            return it
        } as Activity
    }

    override fun getFragmentId(): Int {
        return R.layout.fragment_mine
    }

    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
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

    override fun onStart() {
        super.onStart()
        initDate()
    }

    @SuppressLint("ResourceType")
    fun initDate(){
        headerlayout = mActivity().mNavigationView.getHeaderView(0) as View

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
        mAppToolBar.setTitle("我的")
        //展开侧边栏
        mAppToolBar.onClickMineInfoListen {
            mActivity().mDrawerLayout.openDrawer(GravityCompat.START)
        }

    }

}
