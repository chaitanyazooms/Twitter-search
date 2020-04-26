package com.pairdev.twittersearch.infra

import com.pairdev.twittersearch.search.MainActivity
import com.pairdev.twittersearch.search.di.SearchActivityBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchActivityBindingModule::class])
    abstract fun searchActivity(): MainActivity
}