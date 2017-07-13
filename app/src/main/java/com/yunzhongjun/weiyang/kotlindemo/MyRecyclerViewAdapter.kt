package com.yunzhongjun.weiyang.kotlindemo

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yunzhongjun.weiyang.kotlindemo.data.BaseItemData
import com.yunzhongjun.weiyang.kotlindemo.viewholder.BaseItemHolder
import com.yunzhongjun.weiyang.kotlindemo.viewholder.MyNormalItemViewHolder
import com.yunzhongjun.weiyang.kotlindemo.viewholder.MyTitleItemViewHolder

/**
 * Created by weiyang on 2017/7/11 0011.
 */
class MyRecyclerViewAdapter(dataList: List<BaseItemData>?) : Adapter<RecyclerView.ViewHolder>() {
    val TAG = "MyRecyclerViewAdapter"
    private var dataList: List<BaseItemData>? = null
    init {
        this.dataList = dataList
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var myHolder = holder as BaseItemHolder<BaseItemData>
        myHolder.updateItemData(dataList?.get(position),position)
        Log.d(TAG, "onBindViewHolder")
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        Log.d(TAG, "onCreateViewHolder")
        return getViewHolder(parent, viewType)
    }


    override fun getItemViewType(position: Int): Int {
        if (dataList == null || dataList!!.size<= 0) {//断言！！
            return BaseItemData.ItemType.Unsupport.typeValue
        } else {
            return dataList!!.get(position).getItemType().typeValue
        }
    }

    override fun getItemCount(): Int {
        if (dataList == null) {
            return 0
        } else {
            /* var aaa = dataList as List<BaseItemData>
             aaa.size;*/
            return dataList!!.size//断言 但会产生空指针异常 如果传入null 且无判断
        }
    }

    private fun getViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        //var itemHolder: BaseItemHolder<*>? = null//TODO 整理 此处要用通配符
        var itemHolder: RecyclerView.ViewHolder? = null
        var itemView: View? = null
        when (BaseItemData.ItemType.getTypeValue(viewType)) {
            BaseItemData.ItemType.Unsupport -> {
                //TODO ----
            }
            BaseItemData.ItemType.TypeNormal -> {
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.itemview_normal, parent, false);//此处的parent需要，否则itemview的外层样式消失。attach 则应为false 否则 出现已添加错误
                itemHolder =  MyNormalItemViewHolder(itemView)
                //if(itemHolder1 is BaseItemHolder<*>)
            }
            BaseItemData.ItemType.TypeTitle -> {
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.itemview_title, parent, false);//此处的parent需要，否则itemview的外层样式消失。attach 则应为false 否则 出现已添加错误
                itemHolder = MyTitleItemViewHolder(itemView)
            }
            else -> {
                //TODO ----
            }
        }
        return itemHolder
    }

    fun setDataList(dataList: List<BaseItemData>?) {
        this.dataList = dataList
    }
}