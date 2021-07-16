package com.covidstat.statistic.data.api

import com.covidstat.statistic.data.model.ResponseStat
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StatApi {
    @GET("{path}")
    suspend fun getCountryStat(@Path("path") path: String,
                               @Query("country") country: String): ResponseStat
}