package com.sony.runonsony.base.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ProjectViewModelFactory
@Inject constructor(
    private val creators:
    Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]

        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}