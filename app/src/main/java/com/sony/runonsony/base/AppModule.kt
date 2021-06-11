package com.sony.runonsony.base

import android.content.Context
import com.sony.runonsony.BaseApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: BaseApplication): Context

}