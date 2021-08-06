package com.covidstat.statistic.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.covidstat.statistic.data.api.NewsApi
import com.covidstat.statistic.data.model.ResponseNews
import com.covidstat.statistic.data.util.Access
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(application: Application): AndroidViewModel(application)  {
    val newsLiveData = MutableLiveData<ResponseNews>()

    fun getNewsInfo(newsApi: NewsApi?, ) {
        viewModelScope.launch(Dispatchers.IO) {
            newsApi?.let {
                newsLiveData.postValue(it.getNewsInfo(
                    Access.NEWS_COUNTRY_CODE,
                    Access.NEWS_CATEGORY_NAME,
                    Access.NEWS_API_KEY))
            }
        }
    }
}