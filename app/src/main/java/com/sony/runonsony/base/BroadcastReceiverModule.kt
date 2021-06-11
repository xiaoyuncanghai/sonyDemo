package com.sony.runonsony.base

import com.sony.runonsony.ui.receiver.RefreshDataReceiver
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class BroadcastReceiverModule {

    @ContributesAndroidInjector
    internal abstract fun contributeAlarmReceiver(): RefreshDataReceiver
}