package com.covidstat.statistic.view_model

import android.app.Application
import androidx.lifecycle.*
import com.covidstat.statistic.data.api.StatApi
import com.covidstat.statistic.data.model.ResponseStat
import com.covidstat.statistic.data.util.Access
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StatFragmentViewModel(application: Application): AndroidViewModel(application) {

    val mainLiveData = MutableLiveData<ResponseStat>()
    val minorLiveData = MutableLiveData<ResponseStat>()

     fun getCovidInfo(statApi: StatApi?) {
        viewModelScope.launch(Dispatchers.IO) {
            statApi?.let {
                mainLiveData.postValue(it.getCountryStat(Access.SERVER_PATH_CASES, "France"))
                minorLiveData.postValue(it.getCountryStat(Access.SERVER_PATH_VACCINES, "France"))
            }
        }
    }
}