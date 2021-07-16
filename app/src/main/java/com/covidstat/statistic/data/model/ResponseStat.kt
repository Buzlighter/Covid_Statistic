package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class ResponseStat(
    @SerializedName("All")
    val info: MainInfo) {

    data class MainInfo(
        @SerializedName("confirmed")
        val confirmed: Int,
        @SerializedName("recovered")
        val recovered: Int,
        @SerializedName("deaths")
        val deaths: Int)

    data class VaccinatedInfo(
        @SerializedName("administered")
        val administrated: Int,
        @SerializedName("people_partially_vaccinated")
        val tested: Int)
}

