package com.covidstat.statistic.view.registration_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.covidstat.statistic.R
import com.covidstat.statistic.data.util.Access


class WebVaccineFragment : Fragment(R.layout.fragment_web_view) {
    lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.web_view)

        webView.webViewClient = WebViewClient()
        webView.loadUrl(Access.WEB_VIEW_URL)

        configureWebView()
    }


    @SuppressLint("SetJavaScriptEnabled")
    fun configureWebView() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
    }

    fun canGoBack(webView: WebView): Boolean {
        return if (webView.canGoBack()) {
            webView.goBack()
            true
        } else {
            false
        }
    }

}