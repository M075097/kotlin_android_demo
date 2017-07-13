package com.yunzhongjun.weiyang.kotlindemo

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by weiyang on 2017/7/11 0011.
 */
class MyViewPagerAdapter(pageCount: Int) : PagerAdapter() {

    private var pageCount: Int

    init {
        this.pageCount = pageCount;
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`;
    }

    override fun getCount(): Int {
        return pageCount
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
        //super.destroyItem(container, position, `object`)
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        var imageView: ImageView? = ImageView(container?.context);
        var resId: Int
        when (position) {
            0 -> {
                resId = R.drawable.image_2
            }
            1 -> {
                resId = R.drawable.image_3
            }
            2 -> {
                resId = R.drawable.image_4
            }
            else -> {
                resId = R.drawable.image_aa
            }
        }
        imageView?.setImageDrawable(container?.context?.resources?.getDrawable(resId))
        var layoutParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView?.layoutParams = layoutParams
        imageView?.scaleType =ImageView.ScaleType.CENTER_CROP
        container?.addView(imageView)
        return imageView!!
    }
}