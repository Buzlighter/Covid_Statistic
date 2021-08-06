package com.covidstat.statistic.data.api

import android.app.Application
import com.covidstat.statistic.data.util.Access
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient: Application() {
    private lateinit var okHttpClient: OkHttpClient

    companion object {
        lateinit var statApi: StatApi
        lateinit var newsApi: NewsApi
    }

    override fun onCreate() {
        super.onCreate()
        configureClient()
        configureStatRetrofit()
        configureNewsRetrofit()
    }

    private fun configureClient() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private fun configureStatRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Access.STAT_SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        statApi = retrofit.create(StatApi::class.java)
    }

    private fun configureNewsRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Access.NEWS_SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsApi = retrofit.create(NewsApi::class.java)
    }
}