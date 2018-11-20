package cn.githink.kotlinapp.presenter.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import cn.githink.common.common.AppManager
import cn.githink.common.ext.onClick
import cn.githink.common.presenter.activity.AppMvpActivity
import cn.githink.kotlinapp.R
import cn.githink.kotlinapp.data.entity.TabEntity
import cn.githink.kotlinapp.injection.component.DaggerMainComponent
import cn.githink.kotlinapp.injection.module.MainModule
import cn.githink.kotlinapp.presenter.MainPresenter
import cn.githink.kotlinapp.presenter.fragment.DiscoveryFragment
import cn.githink.kotlinapp.presenter.fragment.HomeFragment
import cn.githink.kotlinapp.presenter.fragment.MineFragment
import cn.githink.kotlinapp.presenter.fragment.NotifyFragment
import cn.githink.kotlinapp.presenter.view.MainView
import cn.githink.provider.common.afterLogin
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.flyco.tablayout.widget.MsgView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import java.util.ArrayList

class MainActivity : AppMvpActivity<MainPresenter>(), MainView,View.OnClickListener {

    //侧边栏头像点击
    private lateinit var headerlayout: View

    //主界面Fragment
    private var mHomeFragment: HomeFragment? = null

    //"发现"Fragment
    private var mDiscoveryFragment: DiscoveryFragment? = null

    private var mNotifyFragment: NotifyFragment? = null

    //"我的"Fragment
    private var mMineFragment: MineFragment? = null

    private val mTitles = arrayOf("首页", "发现", "消息", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private lateinit var toolBar: Toolbar

    private val mTabEntities = ArrayList<CustomTabEntity>()

    //默认为0
    private var mIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)

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
        //初始化ToolBar和侧拉菜单
        initToolBar()
        //初始化底部菜单
        initTab()
        tab_layout.currentTab = mIndex

        switchFragment(mIndex)
        headerlayout = mNavigationView.getHeaderView(0)
        val userNameBtn = headerlayout.find<TextView>(R.id.mUsername)
        userNameBtn.onClick(this)
        val userAvatarBtn = headerlayout.find<CircleImageView>(R.id.mAvatar)
        userAvatarBtn.onClick(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mAvatar,R.id.mUsername ->{
                afterLogin {
                    toast("没有登录，前去登录页")
                }
            }
            else ->{}
        }
    }

    private fun initToolBar() {

        //mNavigationView.setCheckedItem(R.id.nav_call)

        mNavigationView.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                //mDrawerLayout.closeDrawers()
                return true
            }
        })
    }

    private fun initTab() {
        (0 until mTitles.size).mapTo(mTabEntities)
        { TabEntity(mTitles[it],mIconSelectIds[it], mIconUnSelectIds[it]) }

        tab_layout.setTabData(mTabEntities)
        //设置未读消息红点
        tab_layout.showDot(1)
        //设置未读消息背景
        tab_layout.showMsg(2, 5)
        tab_layout.setMsgMargin(3, 0f, 5f)
        val rtv_2_3 = tab_layout.getMsgView(3) as MsgView
        rtv_2_3.backgroundColor = Color.parseColor("#6D8FB0")

        //选中监听
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })

    }

    fun switchFragment(position: Int){
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)

        when(position){
            // 首页
            0 -> {
                mHomeFragment?.let {
                    transaction.show(it)
                } ?: HomeFragment.getInstance(mTitles[position]).let {
                    mHomeFragment = it
                    transaction.add(R.id.fl_container, it, "home")
                }
            }
            //发现
            1 -> mDiscoveryFragment?.let{
                transaction.show(it)
            } ?: DiscoveryFragment.getInstance(mTitles[position]).let {
                mDiscoveryFragment = it
                transaction.add(R.id.fl_container,it,"discovery")
            }
            //消息
            2 -> mNotifyFragment?.let {
                transaction.show(it)
            }?:NotifyFragment.getInstance(mTitles[position]).let {
                mNotifyFragment = it
                transaction.add(R.id.fl_container,it,"notify")
            }
            //我的
            3 -> {
                mMineFragment?.let {
                    transaction.show(it)
                } ?: MineFragment.getInstance(mTitles[position]).let {
                    mMineFragment = it
                    transaction.add(R.id.fl_container, it, "mine")
                }
            }
            else -> {

            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()

    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it) }
        mNotifyFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        //记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }


    override fun injectComponent() {
        DaggerMainComponent.builder()
            .activityComponent(activityComponent)
            .mainModule(MainModule())
            .build()
            .inject(this)
        mPresenter.mView = this
    }


    private var pressTime:Long = 0

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if(time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        }else{
            AppManager.instance.exitApp(this)
        }

    }
}
