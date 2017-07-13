package com.yunzhongjun.weiyang.kotlindemo.viewholder

import android.view.View
import com.yunzhongjun.weiyang.kotlindemo.data.ItemTitleData

/**
 * Created by weiyang on 2017/7/11 0011.
 */
class MyTitleItemViewHolder(itemView: View) : BaseItemHolder<ItemTitleData>(itemView) {
    var titleView: android.widget.TextView? = null;
    override fun initView(itemView: android.view.View) {
        titleView = itemView.findViewById(com.yunzhongjun.weiyang.kotlindemo.R.id.textview_title) as android.widget.TextView
    }

    override fun bindItemData(itemData: com.yunzhongjun.weiyang.kotlindemo.data.ItemTitleData, position: Int) {
        titleView?.text = itemData.title
    }
}