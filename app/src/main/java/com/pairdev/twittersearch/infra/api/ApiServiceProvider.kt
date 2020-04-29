package com.pairdev.twittersearch.infra.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pairdev.twittersearch.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
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
            .addInterceptor(getLoggingInterceptor())
            .addInterceptor(getAuthInterceptor())
    }

    private fun getAuthInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original: Request = chain.request()

                val authToken = ""
                val builder: Request.Builder = original.newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer " + authToken
                    )

                val request: Request = builder.build()

                return chain.proceed(request)
            }
        }
    }

    private fun getLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC

        interceptor.redactHeader("Authorization")
        interceptor.redactHeader("Cookie")

        return interceptor
    }

    private fun getGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }
}
