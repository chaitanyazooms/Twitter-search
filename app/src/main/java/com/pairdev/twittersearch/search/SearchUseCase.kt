package com.pairdev.twittersearch.search

import android.util.Log
import com.pairdev.twittersearch.infra.api.ApiServiceProvider
import com.pairdev.twittersearch.infra.database.TweetDao
import com.pairdev.twittersearch.search.models.TweetSearchResponse
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "SearchUseCase"

class SearchUseCase @Inject constructor(
    private val apiServiceProvider: ApiServiceProvider,
    private val tweetDao: TweetDao
) {

    private val apiService: SearchApiService by lazy {
        apiServiceProvider.getApiService(
            SearchApiService::class.java
        )
    }

    suspend fun searchTweets(query: String) {
        val response: Response<TweetSearchResponse> = apiService.searchResults(query)

        if (response.isSuccessful) {
            response.body()?.apply {
                tweetDao.insert(this.statuses)
            }
        }

        Log.v(TAG, "searchTweets is successful ${response.isSuccessful}")
        Log.v(TAG, "searchTweets is message ${response.message()}")
    }
}
