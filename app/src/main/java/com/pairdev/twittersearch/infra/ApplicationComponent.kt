package com.pairdev.twittersearch.infra

import com.pairdev.twittersearch.core.TwitterApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent : AndroidInjector<TwitterApplication>
