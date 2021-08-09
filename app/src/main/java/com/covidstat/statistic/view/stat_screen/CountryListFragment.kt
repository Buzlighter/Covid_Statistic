package com.covidstat.statistic.view.stat_screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.covidstat.statistic.R
import com.covidstat.statistic.data.model.CountryData
import com.covidstat.statistic.data.util.Access
import com.covidstat.statistic.data.util.FileReaderFromAssets
import com.google.gson.reflect.TypeToken


class CountryListFragment : Fragment(R.layout.fragment_country_list) {

    private lateinit var countrySearch: SearchView
    private lateinit var countryRecycler: RecyclerView
    private lateinit var countryList: List<CountryData>
    private lateinit var countryAdapter: CountryAdapter
    private val bundle = Bundle()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countrySearch = view.findViewById(R.id.country_search)
        countryRecycler = view.findViewById(R.id.country_recycler)

        val type = object: TypeToken<List<CountryData>>() {}.type
        countryList = FileReaderFromAssets.read(Access.COUNTRY_NAME_FILE, requireContext(), type)
        fitRecyclerView()

        countrySearch.setOnQueryTextListener(searchTextListener)
        countryAdapter.setOnItemClickListener(countryListener)
    }

    private fun fitRecyclerView() {
        countryRecycler.apply {
            setHasFixedSize(true)
            val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            AppCompatResources.getDrawable(requireContext(), R.drawable.line_divider_country)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            countryAdapter = CountryAdapter(countryList)
            countryRecycler.adapter = countryAdapter
        }
    }

    private val searchTextListener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            countryAdapter.filter.filter(newText)
            return false
        }
    }

    private val countryListener = object: CountryAdapter.OnItemClickListener{
        override fun onItemClick(countryData: CountryData) {
            bundle.putString(Access.STAT_FRAGMENT, countryData.countryEN)
            parentFragmentManager.commit {
                replace<StatFragment>(R.id.fragment_main_container, Access.STAT_FRAGMENT, bundle)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}