package com.covidstat.statistic.data.util

class Access {
    companion object {
        const val STAT_SERVER_URL: String = "https://covid-api.mmediagroup.fr/v1/"
        const val STAT_SERVER_PATH_CASES = "cases"
        const val STAT_SERVER_PATH_VACCINES = "vaccines"

        const val WEB_VIEW_CHECK_IN_URL = "https://www.gosuslugi.ru/landing/vaccination"

        const val NEWS_SERVER_URL = "https://newsapi.org/v2/"
        const val NEWS_SERVER_PATH_HEADLINES = "top-headlines"
        const val NEWS_COUNTRY_CODE = "ru"
        const val NEWS_CATEGORY_NAME = "health"
        const val NEWS_API_KEY = "72c9997f90b3469b84fee01b8824177f"

        //Transaction Fragments TAGs
        const val MAIN_FRAGMENT = "main"
        const val WEB_VIEW_FRAGMENT = "web_view"
        const val STAT_BUNDLE_KEY = "input_country_key"
        const val NEWS_BUNDLE_KEY = "url_key"

        //Name of file
        const val COUNTRY_NAME_FILE = "countries.json"
    }
}