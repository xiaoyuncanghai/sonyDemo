package com.sony.runonsony.base

import com.sony.runonsony.BaseApplication
import com.sony.runonsony.base.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class, ActivityModule::class, ViewModelModule::class,
        ServiceModule::class, BroadcastReceiverModule::class]
)


interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): ApplicationComponent
    }
}
