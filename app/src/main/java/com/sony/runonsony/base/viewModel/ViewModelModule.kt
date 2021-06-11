package com.sony.runonsony.base.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sony.runonsony.ui.main.viewModel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainActViewModel(mainActViewModel: MainViewModel): ViewModel
    @Binds
    internal abstract fun bindViewModelFactory(factory: ProjectViewModelFactory): ViewModelProvider.Factory
}



