package com.pairdev.twittersearch.infra.di

import com.pairdev.twittersearch.main.MainActivity
import com.pairdev.twittersearch.main.di.MainActivityBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}
