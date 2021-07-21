package com.covidstat.statistic.data.util

import android.view.View
import android.widget.TextView
import com.szagurskii.patternedtextwatcher.PatternedTextWatcher

class TextPattern {
    companion object {
        fun checkNum(textView: TextView, number: Int) {
            when(number) {
                in 1 until 1000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("###"))
                in 1000 until 10000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ###"))
                in 10000 until 100000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("## ###"))
                in 100000 until 1000000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("### ###"))
                in 1000000 until 10000000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ### ###"))
                in 10000000 until 100000000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("## ### ###"))
                in 100000000 until 1000000000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("### ### ###"))
                in 1000000000 until 10000000000 ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ### ### ###"))
            }
        }
    }
}