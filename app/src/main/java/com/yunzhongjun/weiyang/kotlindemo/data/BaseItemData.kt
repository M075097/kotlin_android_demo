package com.yunzhongjun.weiyang.kotlindemo.data

/**
 * Created by weiyang on 2017/7/11 0011.
 */
abstract class BaseItemData {
    abstract fun getItemType(): ItemType

     enum class ItemType(typeValue: Int) {
        TypeNormal(0),
        TypeTitle(1),
        Unsupport(2);

        var typeValue: Int

        init {
            this.typeValue = typeValue;
        }

        companion object {
            //类比JAVA中的静态方法
            fun getTypeValue(typeValue: Int): ItemType {
                for (value in values()) {
                    if (value.typeValue == typeValue) {
                        return value;
                    }
                }
                return Unsupport;
            }
        }

    }
}