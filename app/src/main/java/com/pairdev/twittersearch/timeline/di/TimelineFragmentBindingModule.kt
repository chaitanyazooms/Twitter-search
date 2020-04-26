package com.pairdev.twittersearch.timeline.di

import androidx.lifecycle.ViewModel
import com.pairdev.twittersearch.infra.di.ViewModelKey
import com.pairdev.twittersearch.timeline.TimelineViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface TimelineFragmentBindingModule {
    @Binds
    @IntoMap
    @ViewModelKey(TimelineViewModel::class)
    fun bindTimelineViewModel(viewModel: TimelineViewModel): ViewModel
}
