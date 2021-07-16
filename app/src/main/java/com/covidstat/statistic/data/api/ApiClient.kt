package com.covidstat.statistic.data.api

import android.app.Application
import com.covidstat.statistic.data.util.Access
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient: Application() {
    companion object {
        lateinit var statApi: StatApi
    }


    override fun onCreate() {
        super.onCreate()
        configureClient()
    }

    private fun configureClient() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Access.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        statApi = retrofit.create(StatApi::class.java)
    }

}