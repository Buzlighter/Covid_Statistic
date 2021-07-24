package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class ResponseStat(
    @SerializedName("All")
    val mainInfo: MainInfo?) {

    data class MainInfo(
        @SerializedName("confirmed")
        val confirmed: Int?,
        @SerializedName("recovered")
        val recovered: Int?,
        @SerializedName("deaths")
        val deaths: Int?,
        @SerializedName("administered")
        val administrated: Int?,
        @SerializedName("people_partially_vaccinated")
        val tested: Int?)
}

