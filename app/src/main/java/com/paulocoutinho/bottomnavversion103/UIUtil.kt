package com.paulocoutinho.bottomnavversion103

import android.R
import android.content.res.ColorStateList
import androidx.annotation.ColorRes
import com.cioccarellia.kite.Kite

class UIUtil {

    companion object {

        fun buildColorStateList(
            @ColorRes pressedColorRes: Int,
            @ColorRes defaultColorRes: Int
        ): ColorStateList {
            val pressedColor = Kite.color[pressedColorRes]
            val defaultColor = Kite.color[defaultColorRes]

            return ColorStateList(
                arrayOf(
                    intArrayOf(R.attr.state_selected, R.attr.state_checked),
                    intArrayOf()
                ),
                intArrayOf(
                    pressedColor,
                    defaultColor
                )
            )
        }

    }

}