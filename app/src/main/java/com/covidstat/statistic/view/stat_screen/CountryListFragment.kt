package com.covidstat.statistic.view.stat_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.covidstat.statistic.R
import com.covidstat.statistic.data.model.CountryData
import com.covidstat.statistic.data.util.Access
import com.covidstat.statistic.data.util.FileReaderFromAssets
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream


class CountryListFragment : Fragment(R.layout.fragment_country_list) {
    private lateinit var countryInput: TextInputEditText
    private lateinit var countryRecycler: RecyclerView
    private lateinit var countryList: List<CountryData>

    private val bundle = Bundle()

    // Переделать на список стран с динамическим поиском
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryInput = view.findViewById(R.id.country_input)
        countryRecycler = view.findViewById(R.id.country_recycler)
        countryRecycler.setHasFixedSize(true)



        countryList = FileReaderFromAssets.read(Access.COUNTRY_NAME_FILE, requireContext())


//        showStatButton.setOnClickListener {
//            // Работает транзакция, оптимизировать код
//            bundle.putString(Access.COUNTRY_INPUT_BUNDLE, countryInput.text.toString())
//            parentFragmentManager.commit {
//                replace<StatFragment>(R.id.fragment_main_container, Access.COUNTRY_INPUT_BUNDLE, bundle)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//            }
//        }

    }
}