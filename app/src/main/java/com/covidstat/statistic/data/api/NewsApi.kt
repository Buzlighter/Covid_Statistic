package com.covidstat.statistic.data.api

import com.covidstat.statistic.data.model.ResponseNews
import com.covidstat.statistic.data.util.Access
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(Access.NEWS_SERVER_PATH_HEADLINES)
    suspend fun getNewsInfo(@Query("country") countryCode: String,
                            @Query("category") categoryName: String,
                            @Query("apiKey") key: String) : ResponseNews

}