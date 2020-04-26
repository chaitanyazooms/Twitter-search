package com.pairdev.twittersearch.main.di

import com.pairdev.twittersearch.infra.di.FragmentScoped
import com.pairdev.twittersearch.search.SearchFragment
import com.pairdev.twittersearch.search.di.SearchFragmentBindingModule
import com.pairdev.twittersearch.timeline.TimelineFragment
import com.pairdev.twittersearch.timeline.di.TimelineFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [SearchFragmentBindingModule::class])
    abstract fun bindSearchFragment(): SearchFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [TimelineFragmentBindingModule::class])
    abstract fun bindTimelineFragment(): TimelineFragment
}
