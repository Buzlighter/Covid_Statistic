package com.covidstat.statistic.data.util

class Access {
    companion object {
        const val SERVER_URL: String = "https://covid-api.mmediagroup.fr/v1/"
        const val SERVER_PATH_CASES = "cases"
        const val SERVER_PATH_VACCINES = "vaccines"
        const val COUNTRY_NAME_FILE = "countries.json"

        //Transaction Fragments TAGs
        const val COUNTRY_INPUT_BUNDLE = "input_country"
    }
}