package com.yunzhongjun.weiyang.kotlindemo

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.yunzhongjun.weiyang.kotlindemo.data.BaseItemData
import com.yunzhongjun.weiyang.kotlindemo.data.ItemNormalData
import com.yunzhongjun.weiyang.kotlindemo.data.ItemTitleData

//继承自父类AppCompatActivity  实现接口 View.OnClickListener 对比JAVA实现为 class MainActivity extends AppCompatActivity implements View.OnClickListener{}
class MainActivity : AppCompatActivity(), View.OnClickListener {
    var textView: TextView? = null//变量声明---需要初始化，想要初始化为null 则必须使用A?类型
    var mRecyclerView: RecyclerView? = null
    var mViewPager: ViewPager? = null
    var backButton: ImageView? = null
    var mDataList1: List<BaseItemData>? = null;
    var mDataList: MutableList<BaseItemData>? = null;//Kotlin中的ArrayList声明之后，不能再增删元素，需要使用MutableList代替。泛型使用和JAVA类似
    var adapter: MyRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//调用父类中被覆写的方法，和JAVA中一样
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    //方法声明
    private fun initData() {
        mDataList1 = ArrayList<BaseItemData>()
        //mDataList1?.add()
        var titleData: ItemTitleData? = null
        var normalData: ItemNormalData? = null
        mDataList = mutableListOf<BaseItemData>()
        for (i in 1..4) {// for循环
            titleData = ItemTitleData()
            //(mDataList1 as ArrayList).add(titleData)
            //mDataList1?.add(titleData)
            titleData.title = "分类标题" + i
            mDataList?.add(titleData)//直接使用mDataList.add()时，报错，原因是mDataList声明的类型为A?的类型，要想使用，需要 A? as A 之后使用或者在确认为非空之后直接使用A?的实例a!! Kotlin 会把A?智能转换A
            for (j in 1..5) {
                normalData = ItemNormalData();
                normalData.itemDes = "类型" + i + "下:" + "条目" + j
                normalData.itemIconPath = null;
                mDataList?.add(normalData)
            }
        }
    }

    private fun initView() {
        textView = findViewById(R.id.textview_first) as TextView //强转类型，对比JAVA的(AA)A 实现 Kotlin直接使用 AA as A
        mRecyclerView = findViewById(R.id.recyclerview_kotlindemo) as RecyclerView
        mViewPager = findViewById(R.id.viewpager_kotlindemo) as ViewPager
        backButton = findViewById(R.id.imageview_topbar_back) as ImageView

        backButton?.setOnClickListener(this)
        var str: String = "Kotlin Demo 页面"
        textView?.setText(str)//T此处必须有？号因为A?和A不是同一种类型

        //init ViewPager
        var viewPagerAdapter:MyViewPagerAdapter = MyViewPagerAdapter(3);//新建对象 不需要使用new 类比JAVA 语法：MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(3);
        mViewPager?.adapter = viewPagerAdapter //对象中原有的set/get方法只要符合标准的setter和getter命名规则 则可以直接使用A.property 赋值 其底层依然是调用setter和getter方法

        //init RecyclerView
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = layoutManager;
        adapter = MyRecyclerViewAdapter(mDataList)
        //adapter?.setDataList(mDataList)
        mRecyclerView?.adapter = adapter
    }
    //接口方法覆写
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageview_topbar_back -> {
                this.finish()
            }
            else -> {
                //TODO nothing
            }
        }
        //when 语法实现类比于JAVA中的
      /*  switch(v.getId()){
            case R.id.imageview_topbar_back:
                    break;
            default:
                break;
        }*/

    }
}
