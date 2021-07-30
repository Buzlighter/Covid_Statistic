package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class CountryData(@SerializedName("ru")
                       val countryRU: String,
                       @SerializedName("en")
                       val countryEN: String,)
