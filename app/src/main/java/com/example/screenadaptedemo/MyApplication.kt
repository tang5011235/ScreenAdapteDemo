package com.example.screenadaptedemo

import android.app.Application
import android.content.Context

/**

 * @author：thf on 2021/7/22 14:48

 * 邮箱：tang5011235@163.com

 * name:ScreenAdapteDemo

 * version:

 * @description:

 */
class MyApplication: Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
//        DismetricAdaptUtils.init(baseContext)

    }

    override fun onCreate() {
        super.onCreate()
    }
}