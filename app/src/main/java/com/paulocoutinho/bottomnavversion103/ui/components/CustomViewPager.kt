package com.paulocoutinho.bottomnavversion103.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {

    private var disable = false

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    )

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (disable) false else super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (disable) false else super.onTouchEvent(event)
    }

    fun disableScroll(disable: Boolean) {
        // when disable = true not work the scroll and when disble = false work the scroll
        this.disable = disable
    }
}
