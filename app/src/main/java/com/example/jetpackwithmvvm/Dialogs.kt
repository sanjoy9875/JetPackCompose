package com.example.jetpackwithmvvm

import android.content.Context
import android.text.format.DateFormat.is24HourFormat
import androidx.fragment.app.FragmentManager
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class Dialogs {

    fun openTimePicker(context: Context,childFragmentManager: FragmentManager){
        val isSystem24Hours = is24HourFormat(context)
        val clockFormat = if (isSystem24Hours)
            TimeFormat.CLOCK_24H
        else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .build()

        picker.show(childFragmentManager,"")
    }


}