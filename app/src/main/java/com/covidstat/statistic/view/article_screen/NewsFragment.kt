package com.covidstat.statistic.view.article_screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.covidstat.statistic.R
import com.covidstat.statistic.data.api.ApiClient
import com.covidstat.statistic.data.model.Article
import com.covidstat.statistic.data.model.CountryData
import com.covidstat.statistic.data.util.Access
import com.covidstat.statistic.view.registration_screen.WebVaccineFragment
import com.covidstat.statistic.view.stat_screen.CountryAdapter
import com.covidstat.statistic.view.stat_screen.StatFragment
import com.covidstat.statistic.view_model.NewsViewModel

class NewsFragment : Fragment(R.layout.fragment_news) {
    private val newsViewModel: NewsViewModel by viewModels()
    private lateinit var newsRecycler: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    lateinit var newsList: List<Article?>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsRecycler = view.findViewById(R.id.news_recycler)
        newsViewModel.getNewsInfo(ApiClient.newsApi)



        fitRecyclerView()

    }

    private fun fitRecyclerView() {
        newsRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            AppCompatResources.getDrawable(requireContext(), R.drawable.line_divider_country)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)

            newsViewModel.newsLiveData.observe(viewLifecycleOwner) {
                newsList = ArrayList(it.articleList)
                newsAdapter = NewsAdapter(newsList)
                newsRecycler.adapter = newsAdapter
                newsAdapter.setOnItemClickListener(newsListener)
            }
        }
    }

    // Реализовать общий webView и сделать переход на сайт новостей
    private val newsListener = object: NewsAdapter.OnItemClickListener{
        override fun onItemClick(article: Article?) {
//            parentFragmentManager.commit {
//                replace<WebVaccineFragment>(R.id.fragment_main_container, Access.WEB_VACCINE_FRAGMENT)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//            }
        }
    }
}