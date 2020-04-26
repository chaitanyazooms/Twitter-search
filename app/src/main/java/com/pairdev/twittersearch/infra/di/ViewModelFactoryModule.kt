package com.pairdev.twittersearch.infra.di

import androidx.lifecycle.ViewModelProvider
import com.pairdev.twittersearch.infra.di.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
