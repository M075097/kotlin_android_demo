package com.yunzhongjun.weiyang.kotlindemo.data

/**
 * Created by weiyang on 2017/7/11 0011.
 */
class ItemNormalData : BaseItemData() {
    var itemIconPath: String? = null
    var itemDes: String? = null
    override fun getItemType(): BaseItemData.ItemType {
        return BaseItemData.ItemType.TypeNormal;
    }

}