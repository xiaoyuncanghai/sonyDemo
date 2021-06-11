package com.sony.runonsony.base

import com.sony.runonsony.ui.main.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector


@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}