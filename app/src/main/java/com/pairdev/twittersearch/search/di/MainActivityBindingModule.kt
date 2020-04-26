package com.pairdev.twittersearch.search.di

import com.pairdev.twittersearch.infra.di.ActivityScoped
import com.pairdev.twittersearch.infra.di.FragmentScoped
import com.pairdev.twittersearch.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [SearchFragmentBindingModule::class])
    abstract fun bindSearchFragment(): SearchFragment
}
