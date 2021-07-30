package com.covidstat.statistic.view.main_screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.*
import com.covidstat.statistic.R
import com.covidstat.statistic.view.stat_screen.CountryListFragment


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {
    private lateinit var statButton: AppCompatButton
    private lateinit var articleButton: AppCompatButton
    private lateinit var checkInButton: AppCompatButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        statButton = view.findViewById(R.id.stat_button)
        articleButton = view.findViewById(R.id.article_button)
        checkInButton = view.findViewById(R.id.check_in_button)

        statButton.setOnClickListener {
            parentFragmentManager.commit {
                replace<CountryListFragment>(R.id.fragment_main_container)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }

}