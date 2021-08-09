package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class ResponseStat(
    @SerializedName("All")
    val mainInfo: MainInfo?) {

    data class MainInfo(
        @SerializedName("confirmed")
        val confirmed: Long?,
        @SerializedName("people_vaccinated")
        val people_vaccinated: Long?,
        @SerializedName("deaths")
        val deaths: Long?,
        @SerializedName("people_partially_vaccinated")
        val tested: Long?,
        @SerializedName("population")
        val population: Long?)
}

