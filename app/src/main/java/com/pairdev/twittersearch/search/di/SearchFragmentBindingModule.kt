package com.pairdev.twittersearch.search.di

import androidx.lifecycle.ViewModel
import com.pairdev.twittersearch.infra.di.ViewModelKey
import com.pairdev.twittersearch.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchFragmentBindingModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel
}
