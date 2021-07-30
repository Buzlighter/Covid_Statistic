package com.covidstat.statistic.view.stat_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.covidstat.statistic.R
import com.covidstat.statistic.data.model.CountryData

class CountryAdapter(private val countryList: List<CountryData>):
    RecyclerView.Adapter<CountryAdapter.CountryHolder>(), Filterable {

    val fullCountryList = ArrayList<CountryData>(countryList)

    inner class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val countryView = inflater.inflate(R.layout.country_item, parent, false)

        return CountryHolder(countryView)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val currentCountryData: CountryData = countryList[position]
        holder.countryName.text = currentCountryData.countryRU
    }

    override fun getItemCount(): Int {
        return countryList.size
    }



    override fun getFilter(): Filter {
        return countryFilter;
    }

    private val countryFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            TODO("Not yet implemented")
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            TODO("Not yet implemented")
        }
    }
}