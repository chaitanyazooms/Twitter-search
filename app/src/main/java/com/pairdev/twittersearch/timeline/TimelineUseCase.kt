package com.pairdev.twittersearch.timeline

import androidx.lifecycle.asFlow
import com.pairdev.twittersearch.core.models.Tweet
import com.pairdev.twittersearch.infra.api.ApiServiceProvider
import com.pairdev.twittersearch.infra.database.TweetDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val TAG = "TimelineUseCase"

class TimelineUseCase @Inject constructor(
    private val apiServiceProvider: ApiServiceProvider,
    private val tweetDao: TweetDao
) {

    fun getTimelineTweets(): Flow<List<Tweet>> {
        return tweetDao.getAllTweets().asFlow<List<Tweet>>()
    }
}
