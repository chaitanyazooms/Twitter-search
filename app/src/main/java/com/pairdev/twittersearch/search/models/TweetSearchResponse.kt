package com.pairdev.twittersearch.search.models

import com.pairdev.twittersearch.core.models.Tweet

data class TweetSearchResponse(val statuses: List<Tweet>)
