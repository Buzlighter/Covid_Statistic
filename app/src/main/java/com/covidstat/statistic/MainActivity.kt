package com.covidstat.statistic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import com.covidstat.statistic.data.api.ApiClient
import com.covidstat.statistic.data.api.StatApi
import com.covidstat.statistic.view_model.MainViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

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

        mainViewModel.getCovidInfo(ApiClient.statApi)

        mainLayout.visibility = View.VISIBLE
        mainViewModel.statLiveData.observe(this) {
            it?.let {
                firstFieldData.text = it.info.confirmed.toString()
                secondFieldData.text = it.info.recovered.toString()
                thirdFieldData.text = it.info.deaths.toString()
            }

        }
    }
}