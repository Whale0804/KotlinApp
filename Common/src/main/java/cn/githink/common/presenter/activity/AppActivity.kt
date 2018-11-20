package cn.githink.common.presenter.activity

import android.os.Bundle
import cn.githink.common.common.AppManager
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

abstract class AppActivity: RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
        //渐进式状态栏
        StatusBarUtil.setTranslucent(this, 39)
        setContentView(layoutId())
        //初始化视图
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    /**
     * 初始化数据
     */
    override fun onStart() {
        super.onStart()
        //初始化数据
        initData()
    }

    /**
     * 加载布局
     */
    abstract fun layoutId():Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

}