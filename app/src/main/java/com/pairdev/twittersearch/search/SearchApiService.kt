package com.pairdev.twittersearch.search

import com.pairdev.twittersearch.search.models.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {
    @GET("search/tweets.json")
    suspend fun searchResults(@Query("q") query: String): SearchResponse
}
