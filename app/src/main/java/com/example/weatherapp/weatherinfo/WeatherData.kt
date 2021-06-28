package com.example.weatherapp.weatherinfo

import java.io.Serializable

class WeatherData : Serializable {
    var weather: List<WeatherDataInfo> = mutableListOf()
    var main: Main = Main()
    var visibility: Int = 0
    var wind: Wind = Wind()
}