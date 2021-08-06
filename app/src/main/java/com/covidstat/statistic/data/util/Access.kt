package com.covidstat.statistic.data.util

class Access {
    companion object {
        const val STAT_SERVER_URL: String = "https://covid-api.mmediagroup.fr/v1/"
        const val STAT_SERVER_PATH_CASES = "cases"
        const val STAT_SERVER_PATH_VACCINES = "vaccines"

        const val WEB_VIEW_URL = "https://www.gosuslugi.ru/landing/vaccination"

        const val NEWS_SERVER_URL = "https://newsapi.org/v2/"
        const val NEWS_SERVER_PATH_HEADLINES = "top-headlines"
        const val NEWS_COUNTRY_CODE = "ru"
        const val NEWS_CATEGORY_NAME = "health"
        const val NEWS_API_KEY = "72c9997f90b3469b84fee01b8824177f"

        //Transaction Fragments TAGs
        const val STAT_FRAGMENT = "input_country"
        const val WEB_VACCINE_FRAGMENT = "webView"

        //Name of file
        const val COUNTRY_NAME_FILE = "countries.json"
    }
}