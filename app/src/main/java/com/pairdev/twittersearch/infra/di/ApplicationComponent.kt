package com.pairdev.twittersearch.infra.di

import com.pairdev.twittersearch.core.TwitterApplication
import com.pairdev.twittersearch.infra.di.ActivityBindingModule
import com.pairdev.twittersearch.infra.di.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent : AndroidInjector<TwitterApplication>
