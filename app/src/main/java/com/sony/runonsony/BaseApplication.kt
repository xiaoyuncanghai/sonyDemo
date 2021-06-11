package com.sony.runonsony

import android.app.Application
import com.sony.runonsony.base.AppInjector
import com.sony.runonsony.base.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }

}