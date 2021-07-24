package com.covidstat.statistic

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.covidstat.statistic.data.util.Access
import com.google.android.material.textfield.TextInputEditText

class CountryInputFragment : Fragment(R.layout.fragment_country_input) {
    private lateinit var countryInput: TextInputEditText
    private lateinit var showStatButton: AppCompatButton

    private val bundle = Bundle()

    // Переделать на список стран с динамическим поиском
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryInput = view.findViewById(R.id.country_input)
        showStatButton = view.findViewById(R.id.show_stat_button)

        showStatButton.setOnClickListener {
            // Работает транзакция, оптимизировать код
            bundle.putString(Access.COUNTRY_INPUT_BUNDLE, countryInput.text.toString())
            parentFragmentManager.commit {
                replace<StatFragment>(R.id.fragment_main_container, Access.COUNTRY_INPUT_BUNDLE, bundle)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}