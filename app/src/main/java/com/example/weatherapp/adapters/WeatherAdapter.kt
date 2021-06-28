package com.example.weatherapp.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.weatherapp.weatherinfo.WeatherData

class WeatherAdapter(context: Context, resource: Int, objects: MutableList<WeatherData>) :
    ArrayAdapter<WeatherData>(
        context,
        resource,
        objects
    ) {
}