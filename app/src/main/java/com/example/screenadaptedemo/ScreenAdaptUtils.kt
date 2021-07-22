package com.example.screenadaptedemo

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi
import java.lang.ref.WeakReference

/**

 * @author：thf on 2021/7/22 10:18

 * 邮箱：tang5011235@163.com

 * name:ScreenAdapteDemo

 * version:

 * @description:

 */
class ScreenAdaptUtils @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1) private constructor(context: Context) {
    private val designWidth = 1080f
    private val designHeight = 1920f
    private var displayWidth = 0f
    private var displayHeight = 0f

    private var mContext: WeakReference<Context> = WeakReference(context)

    init {
        val display = context.display
        display?.apply {
            val metrics = DisplayMetrics()
            getRealMetrics(metrics)
            displayWidth = metrics.widthPixels.toFloat()
            displayHeight = metrics.heightPixels - getStatueBarHeight()
        }
    }

    companion object {
        private var screenAdaptUtils: ScreenAdaptUtils? = null


        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        @JvmStatic
        fun getInstance(context: Context): ScreenAdaptUtils {
            if (screenAdaptUtils == null) {
                screenAdaptUtils = ScreenAdaptUtils(context)
            }
            return screenAdaptUtils!!
        }
    }

    /**
     * 获取状态栏高度
     */
    fun getStatueBarHeight(): Float {
        mContext.get()?.let {
            val resId: Int = it.resources.getIdentifier("status_bar_height", "dimen", "android")
            return if (resId > 0) {
                //获取具体的像素值
                it.resources.getDimensionPixelSize(resId).toFloat()
            } else 0f
        }
        return 0f
    }

    /**
     * 宽度缩放比列
     */
    fun widthScaleRadio(): Float {
        if (designWidth != 0f) {
            return displayWidth / designWidth
        }
        return 0f
    }

    /**
     * 高度缩放比列
     */
    fun heightScaleRadio(): Float {
        if (designHeight != 0f) {
            return displayHeight / designHeight
        }
        return 0f
    }

}