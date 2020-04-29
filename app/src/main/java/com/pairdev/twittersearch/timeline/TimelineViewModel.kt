package com.pairdev.twittersearch.timeline

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pairdev.twittersearch.core.models.Tweet
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimelineViewModel @Inject constructor(private val useCase: TimelineUseCase) : ViewModel() {

    val timelineLiveData = MutableLiveData<List<Tweet>>()

    fun getTimelineFlow() {
        viewModelScope.launch {
            useCase.getTimelineTweets()
                .collect {
                    timelineLiveData.postValue(it)
                }
        }
    }
}
