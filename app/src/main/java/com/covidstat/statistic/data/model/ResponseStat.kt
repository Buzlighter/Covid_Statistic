package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class ResponseStat(
    @SerializedName("All")
    val mainInfo: MainInfo?) {

    data class MainInfo(
        @SerializedName("confirmed")
        val confirmed: Long?,
        @SerializedName("recovered")
        val recovered: Long?,
        @SerializedName("deaths")
        val deaths: Long?,
        @SerializedName("administered")
        val administrated: Long?,
        @SerializedName("people_partially_vaccinated")
        val tested: Long?)
}

