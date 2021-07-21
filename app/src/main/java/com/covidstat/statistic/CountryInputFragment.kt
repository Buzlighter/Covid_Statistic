package com.covidstat.statistic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.textfield.TextInputEditText

class CountryInputFragment : Fragment(R.layout.fragment_country_input) {
    private lateinit var countryInput: TextInputEditText
    private lateinit var showStatButton: AppCompatButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryInput = view.findViewById(R.id.country_input)
        showStatButton = view.findViewById(R.id.show_stat_button)


        showStatButton.setOnClickListener {
            parentFragmentManager.commit {
                replace<StatFragment>(R.id.fragment_main_container)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}