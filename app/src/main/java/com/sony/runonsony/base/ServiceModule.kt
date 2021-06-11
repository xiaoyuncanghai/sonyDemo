package com.sony.runonsony.base

import com.sony.runonsony.ui.service.RefreshService
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class ServiceModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRefreshTokenService(): RefreshService
}