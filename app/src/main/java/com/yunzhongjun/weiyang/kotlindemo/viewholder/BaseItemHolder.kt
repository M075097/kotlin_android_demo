package com.yunzhongjun.weiyang.kotlindemo.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by weiyang on 2017/7/11 0011.
 */
abstract class BaseItemHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val TAG = "BaseItemHolder"
    private var itemData: T? = null

    init {
        initView(itemView)
    }

    public fun updateItemData(itemData: T?, position: Int) {
        this.itemData = itemData
        if (itemData == null) {
            return
        }
        if (itemView != null) {
            try {
                bindItemData(itemData, position);
            } catch (e: java.lang.Exception) {
                android.util.Log.d(TAG, "绑定数据出错！")
                e.printStackTrace()
            }
        }
    }

    fun getItemData(): T? {
        return this.itemData
    }

    abstract fun initView(itemView: android.view.View)
    abstract fun bindItemData(itemData: T, position: Int)
}