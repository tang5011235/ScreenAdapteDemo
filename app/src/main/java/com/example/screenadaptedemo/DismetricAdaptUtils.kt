package com.example.screenadaptedemo

import android.content.Context
import android.util.DisplayMetrics

/**

 * @author：thf on 2021/7/22 13:52

 * 邮箱：tang5011235@163.com

 * name:ScreenAdapteDemo

 * version:

 * @description:

 */
class DismetricAdaptUtils private constructor(context: Context) {

    private var scaleRadio = 0f


    init {
        val display = context.display
        display?.apply {
            val metrics = DisplayMetrics()
            getRealMetrics(metrics)

            val displayMetrics = context.resources.displayMetrics
            //density = px/dp
            scaleRadio = displayMetrics.widthPixels / DESIGN_WIDTH
            displayMetrics.density = scaleRadio
            displayMetrics.scaledDensity = scaleRadio
            displayMetrics.densityDpi = (displayMetrics.scaledDensity * 160).toInt()
        }
    }

    companion object {
        private const val DESIGN_WIDTH = 1080f / (420f/160f)
        private const val DESIGN_HEIGHT = 1920f / 420


        @JvmStatic
        fun init(context: Context) {
            DismetricAdaptUtils(context)
        }
    }


}