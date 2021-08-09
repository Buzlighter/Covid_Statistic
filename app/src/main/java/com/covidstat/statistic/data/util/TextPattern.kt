package com.covidstat.statistic.data.util

import android.widget.TextView
import androidx.core.util.rangeTo
import com.szagurskii.patternedtextwatcher.PatternedTextWatcher

class TextPattern {
    companion object {
        fun checkNumForPattern(textView: TextView, number: Long) {
            when(number) {
                in 0L until 1000L ->
                   textView.addTextChangedListener(PatternedTextWatcher("###"))
                in 1000L until 10000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ###"))
                in 10000L until 100000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("## ###"))
                in 100000L until 1000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("### ###"))
                in 1000000L until 10000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ### ###"))
                in 10000000L until 100000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("## ### ###"))
                in 100000000L until 1000000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("### ### ###"))
                in 1000000000L until 10000000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("# ### ### ###"))
                in 10000000000L until 100000000000L ->
                    textView.addTextChangedListener(PatternedTextWatcher("## ### ### ###"))
            }
        }

        fun checkDateForPattern(textView: TextView) {
            textView.addTextChangedListener(PatternedTextWatcher("##########"))
        }
    }
}