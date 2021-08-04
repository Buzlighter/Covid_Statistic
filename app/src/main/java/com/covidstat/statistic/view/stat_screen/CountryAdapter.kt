@file:Suppress("UNCHECKED_CAST")

package com.covidstat.statistic.view.stat_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.covidstat.statistic.R
import com.covidstat.statistic.data.model.CountryData


class CountryAdapter(countriesList: List<CountryData>):
    RecyclerView.Adapter<CountryAdapter.CountryHolder>(), Filterable {

    private val fullCountryList = ArrayList<CountryData>(countriesList)
    private val countryList = ArrayList<CountryData>(countriesList)
    private lateinit var listener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(countryData: CountryData)
    }

    fun setOnItemClickListener(itemListener: OnItemClickListener) {
        listener = itemListener
    }

    inner class CountryHolder(itemView: View, itemListener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)

        init {
            itemView.setOnClickListener {
                itemListener.onItemClick(countryList[bindingAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val countryView = inflater.inflate(R.layout.country_item, parent, false)

        return CountryHolder(countryView, listener)
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

    private val countryFilter = object: Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = ArrayList<CountryData>()
            if (constraint.isNullOrEmpty()) {
                filteredList.addAll(fullCountryList)
            }
            else {
                val filterPattern = constraint.toString().lowercase().trim()
                for (item: CountryData in fullCountryList) {
                    if (item.countryRU.lowercase().startsWith(filterPattern))
                        filteredList.add(item)
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            countryList.clear()
            countryList.addAll(results?.values as List<CountryData>)
            notifyDataSetChanged()
        }
    }
}