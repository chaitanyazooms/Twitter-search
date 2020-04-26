package com.pairdev.twittersearch.infra.di

import com.pairdev.twittersearch.search.MainActivity
import com.pairdev.twittersearch.search.di.MainActivityBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}
