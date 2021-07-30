package com.covidstat.statistic.data.util

import android.content.Context
import com.covidstat.statistic.data.model.CountryData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class  FileReaderFromAssets {
     companion object  {
         fun <T> read(fileName: String, context: Context) : List<T> {
             val gson = Gson()
             val inputStream: InputStream = context.assets.open(fileName)
             val text = inputStream.readBytes().toString(Charsets.UTF_8)
             val type = object: TypeToken<List<T>>() {}.type
             return  gson.fromJson(text, type)
         }
     }

}