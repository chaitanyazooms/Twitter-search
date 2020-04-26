package com.pairdev.twittersearch.search

import com.pairdev.twittersearch.core.models.Tweet
import com.pairdev.twittersearch.infra.api.ApiServiceProvider
import javax.inject.Inject

class SearchUseCase @Inject constructor(val apiServiceProvider: ApiServiceProvider) {

    private val apiService: SearchApiService by lazy { apiServiceProvider.getApiService(SearchApiService::class.java) }

    suspend fun searchTweets(query: String): List<Tweet> {
        apiService.searchResults(query)
        return emptyList()
    }
}
