package com.pairdev.twittersearch.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val searchUseCase: SearchUseCase) : ViewModel() {

    companion object {
        const val NAVIGATE_TO_TIMELINE = "NAVIGATE_TO_TIMELINE"
    }

    private val navigationLiveData = MutableLiveData<String>()

    fun getNavigationLiveData(): LiveData<String> {
        return navigationLiveData
    }

    fun onSearchClick(searchText: String) {
        viewModelScope.launch {
            searchUseCase.searchTweets(searchText)
        }

        navigationLiveData.value = NAVIGATE_TO_TIMELINE
    }
}
