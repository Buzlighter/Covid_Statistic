package com.covidstat.statistic

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.covidstat.statistic.data.api.ApiClient
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statLayout = view.findViewById(R.id.mainLayout)
        firstFieldData = view.findViewById(R.id.first_data)
        secondFieldData = view.findViewById(R.id.second_data)
        thirdFieldData = view.findViewById(R.id.third_data)
        fourthFieldData = view.findViewById(R.id.fourth_data)
        fifthFieldData = view.findViewById(R.id.fifth_data)

        statFragmentViewModel.getCovidInfo(ApiClient.statApi)

        statLayout.visibility = View.VISIBLE
        setMainData()
        setMinorData()
    }

    private fun setMainData() {
        statFragmentViewModel.mainLiveData.observe(requireActivity()) {
            it?.let {
                TextPattern.apply {
                    checkNum(firstFieldData, it.mainInfo.confirmed)
                    checkNum(secondFieldData, it.mainInfo.recovered)
                    checkNum(thirdFieldData, it.mainInfo.deaths)
                }

                firstFieldData.text = it.mainInfo.confirmed.toString()
                secondFieldData.text = it.mainInfo.recovered.toString()
                thirdFieldData.text = it.mainInfo.deaths.toString()
            }
        }
    }

    private fun setMinorData() {
        statFragmentViewModel.minorLiveData.observe(requireActivity()) {
            it?.let {
                TextPattern.apply {
                    checkNum(fourthFieldData, it.mainInfo.tested)
                    checkNum(fifthFieldData, it.mainInfo.administrated)
                }

                fourthFieldData.text = it.mainInfo.tested.toString()
                fifthFieldData.text = it.mainInfo.administrated.toString()
            }
        }
    }
}