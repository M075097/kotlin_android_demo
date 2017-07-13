package com.yunzhongjun.weiyang.kotlindemo.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.yunzhongjun.weiyang.kotlindemo.R
import com.yunzhongjun.weiyang.kotlindemo.data.ItemNormalData

/**
 * Created by weiyang on 2017/7/11 0011.
 */
class MyNormalItemViewHolder(itemView: View) : BaseItemHolder<ItemNormalData>(itemView), View.OnClickListener {
    //默认构造函数，直接传递子类参数到父类
    var itemIcon: ImageView? = null
    var itemdes: TextView? = null

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageview_itemicon -> {
                Toast.makeText(v?.context, "点击了图标!", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_itemdes -> {
                Toast.makeText(v?.context, "点击了文字!", Toast.LENGTH_SHORT).show()
            }
            else -> {
            }
        }
    }

    override fun initView(itemView: View) {
        itemIcon = itemView.findViewById(R.id.imageview_itemicon) as ImageView
        itemdes = itemView.findViewById(R.id.textview_itemdes) as TextView
        itemIcon?.setOnClickListener(this)
        itemdes?.setOnClickListener(this)
    }

    override fun bindItemData(itemData: ItemNormalData, position: Int) {
        if (itemData.itemIconPath == null) {
            itemIcon?.setImageDrawable(itemView?.context?.resources?.getDrawable(R.drawable.icon))
        } else {
            //TODO 加载网络图片
        }
        if (itemData.itemDes == null) {
            itemdes?.text = "默认文字。。。"
        } else {
            itemdes?.text = itemData.itemDes
        }
    }

}
