package com.pairdev.twittersearch.infra.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

val baseURL = "https://api.twitter.com/1.1/"

@Singleton
class ApiServiceProvider @Inject constructor() {
    val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .client(getOkHttpBuilder().build())
    }

    fun <T : Any> getApiService(serviceClass: Class<T>): T {
        return retrofitBuilder.build().create(serviceClass)
    }

    private fun getOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient().newBuilder()
    }

    private fun getGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }
}
