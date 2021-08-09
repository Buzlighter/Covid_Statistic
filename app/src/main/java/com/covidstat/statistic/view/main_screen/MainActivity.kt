package com.covidstat.statistic.view.main_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.covidstat.statistic.R
import com.covidstat.statistic.data.util.Access
import com.covidstat.statistic.view.registration_screen.WebVaccineFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<MainScreenFragment>(R.id.fragment_main_container)
                setReorderingAllowed(true)
            }
        }
    }


    override fun onBackPressed() {
        val webViewFragment: Fragment? = supportFragmentManager.findFragmentByTag(Access.WEB_VACCINE_FRAGMENT)
        if (webViewFragment is WebVaccineFragment) {
            val goBack: Boolean = webViewFragment.canGoBack(webViewFragment.webView)
            if (!goBack) super.onBackPressed()
        }
        else {
            super.onBackPressed()
        }
    }
}