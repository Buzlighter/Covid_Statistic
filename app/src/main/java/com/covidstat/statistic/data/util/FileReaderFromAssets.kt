package com.covidstat.statistic.data.util

import android.content.Context
import com.google.gson.Gson
import java.io.InputStream
import java.lang.reflect.Type

class  FileReaderFromAssets {
     companion object  {
         fun <T> read(fileName: String, context: Context, type: Type): List<T> {
             val gson = Gson()
             val inputStream: InputStream = context.assets.open(fileName)
             val text = inputStream.readBytes().toString(Charsets.UTF_8)
             return  gson.fromJson(text, type)
         }
     }

}