package com.covidstat.statistic.data.model

import com.google.gson.annotations.SerializedName

data class ResponseNews(@SerializedName("articles")
                        val article: List<Article>?) {

    data class Article(@SerializedName("source")
                       val source: Source?,
                       @SerializedName("title")
                       val title: String?,
                       @SerializedName("description")
                       val description: String?,
                       @SerializedName("url")
                       val url: String?,
                       @SerializedName("urlToImage")
                       val image: String?,
                       @SerializedName("publishedAt")
                       val publishedDate: String?,) {

        data class Source(@SerializedName("name")
                          val name: String?)
    }
}
