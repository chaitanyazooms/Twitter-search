package com.pairdev.twittersearch.search.di

import com.pairdev.twittersearch.infra.FragmentScoped
import com.pairdev.twittersearch.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SearchActivityBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [SearchFragmentBindingModule::class])
    abstract fun bindSearchFragment(): SearchFragment
}