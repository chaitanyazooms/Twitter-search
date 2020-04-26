package com.pairdev.twittersearch.core

import android.app.Activity
import android.app.Application
import com.pairdev.twittersearch.infra.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TwitterApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        val applicationComponent = DaggerApplicationComponent.builder().build()

        applicationComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}
