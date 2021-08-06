package com.covidstat.statistic.view.article_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.covidstat.statistic.R
import com.covidstat.statistic.data.api.ApiClient
import com.covidstat.statistic.view_model.NewsViewModel

class NewsFragment : Fragment(R.layout.fragment_news) {
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel.getNewsInfo(ApiClient.newsApi)
    }

    private fun setNewsData() {

    }
}