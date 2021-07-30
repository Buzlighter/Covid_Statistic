package com.covidstat.statistic.view.stat_screen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.covidstat.statistic.R
import com.covidstat.statistic.data.api.ApiClient
import com.covidstat.statistic.data.model.ResponseStat
import com.covidstat.statistic.data.util.Access
import com.covidstat.statistic.data.util.TextPattern
import com.covidstat.statistic.view_model.StatFragmentViewModel


class StatFragment : Fragment(R.layout.fragment_stat) {
    private val statFragmentViewModel: StatFragmentViewModel by viewModels()

    private lateinit var statLayout: LinearLayoutCompat
    private lateinit var firstFieldData: TextView
    private lateinit var secondFieldData: TextView
    private lateinit var thirdFieldData: TextView
    private lateinit var fourthFieldData: TextView
    private lateinit var fifthFieldData: TextView

    private val noData = "Нет данных"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statLayout = view.findViewById(R.id.mainLayout)
        firstFieldData = view.findViewById(R.id.first_data)
        secondFieldData = view.findViewById(R.id.second_data)
        thirdFieldData = view.findViewById(R.id.third_data)
        fourthFieldData = view.findViewById(R.id.fourth_data)
        fifthFieldData = view.findViewById(R.id.fifth_data)

        // Работает транзакция, оптимизировать код
        val str = this.arguments?.get(Access.COUNTRY_INPUT_BUNDLE)

        statFragmentViewModel.getCovidInfo(ApiClient.statApi)

        statLayout.visibility = View.VISIBLE
        setMainData()
        setMinorData()
    }

    private fun setMainData() {
        statFragmentViewModel.mainLiveData.observe(requireActivity()) {
            it?.let {
               setNumPatternMainData(it)
               firstFieldData.text = it.mainInfo?.confirmed?.toString() ?: noData
               secondFieldData.text = it.mainInfo?.recovered?.toString() ?: noData
               thirdFieldData.text = it.mainInfo?.deaths?.toString() ?: noData
            }
        }
    }

    private fun setMinorData() {
        statFragmentViewModel.minorLiveData.observe(requireActivity()) {
            it?.let {
                setNumPatternMinorData(it)
                fourthFieldData.text = it.mainInfo?.tested?.toString() ?: noData
                fifthFieldData.text = it.mainInfo?.administrated?.toString() ?: noData
            }
        }
    }

    private fun setNumPatternMainData(responseStat: ResponseStat) {
        responseStat.mainInfo?.let {
            it.confirmed?.let { itNum ->
                TextPattern.checkNumForPattern(firstFieldData, itNum)
            }
            it.recovered?.let { itNum ->
                TextPattern.checkNumForPattern(secondFieldData, itNum)
            }
            it.deaths?.let { itNum ->
                TextPattern.checkNumForPattern(thirdFieldData, itNum)
            }
        }
    }

    private fun setNumPatternMinorData(responseStat: ResponseStat) {
        responseStat.mainInfo?.let {
            it.tested?.let { itNum ->
                TextPattern.checkNumForPattern(fourthFieldData, itNum)
            }
            it.administrated?.let { itNum ->
                TextPattern.checkNumForPattern(fifthFieldData, itNum)
            }
        }
    }
}