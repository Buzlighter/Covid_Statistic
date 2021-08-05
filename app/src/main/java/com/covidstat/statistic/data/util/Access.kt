package com.covidstat.statistic.data.util

class Access {
    companion object {
        const val SERVER_URL: String = "https://covid-api.mmediagroup.fr/v1/"
        const val SERVER_PATH_CASES = "cases"
        const val SERVER_PATH_VACCINES = "vaccines"
        const val COUNTRY_NAME_FILE = "countries.json"
        const val WEB_VIEW_URL = "https://www.gosuslugi.ru/landing/vaccination"

        //Transaction Fragments TAGs
        const val STAT_FRAGMENT = "input_country"
        const val WEB_VACCINE_FRAGMENT = "webView"
    }
}