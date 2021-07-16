package com.covidstat.statistic.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.*
import com.covidstat.statistic.data.api.StatApi
import com.covidstat.statistic.data.model.ResponseStat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MainViewModel(application: Application): AndroidViewModel(application) {

    val statLiveData = MutableLiveData<ResponseStat>()

     fun getCovidInfo(statApi: StatApi?) {
        viewModelScope.launch(Dispatchers.IO) {
            statApi?.let {
                statLiveData.postValue(it.getCountryStat("Germany"))
            }
        }
    }
}