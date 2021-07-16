package com.covidstat.statistic

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.covidstat.statistic.data.api.ApiClient
import com.covidstat.statistic.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()


    private lateinit var mainLayout: ConstraintLayout
    private lateinit var firstFieldData: TextView
    private lateinit var secondFieldData: TextView
    private lateinit var thirdFieldData: TextView
    private lateinit var fourthFieldData: TextView
    private lateinit var fifthFieldData: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)
        firstFieldData = findViewById(R.id.first_data)
        secondFieldData = findViewById(R.id.second_data)
        thirdFieldData = findViewById(R.id.third_data)
        fourthFieldData = findViewById(R.id.fourth_data)
        fifthFieldData = findViewById(R.id.fifth_data)

        mainViewModel.getCovidInfo(ApiClient.statApi)

        setMainData()
        setMinorData()
    }

    private fun setMainData() {
        mainLayout.visibility = View.VISIBLE
        mainViewModel.mainLiveData.observe(this) {
            it?.let {
                firstFieldData.text = it.mainInfo.confirmed.toString()
                secondFieldData.text = it.mainInfo.recovered.toString()
                thirdFieldData.text = it.mainInfo.deaths.toString()
            }
        }
    }

    private fun setMinorData() {
        mainViewModel.minorLiveData.observe(this) {
            it?.let {
                fourthFieldData.text = it.mainInfo.tested.toString()
                fifthFieldData.text = it.mainInfo.administrated.toString()
            }
        }
    }

}