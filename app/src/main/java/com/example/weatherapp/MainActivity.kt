package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.weatherapp.weatherinfo.WeatherData
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun setArea(v: View?) {
        val area = findViewById<EditText>(R.id.area_field).text.toString()
        val apiKey = "2a619a56722bfe49e858f019625aa9a1"
        val uri =
            "https://api.openweathermap.org/data/2.5/weather?q=$area&APPID=$apiKey&units=metric&lang=ru"

        val jsonString = UrlData().execute(uri).get()
        val gson = Gson()

        val weatherData : WeatherData = gson.fromJson(jsonString.toString(), WeatherData::class.java)

        //convert "weather description to normal case (Abc)"
        val weatherInfoDescription = weatherData.weather[0].description
        weatherData.weather[0].description = weatherInfoDescription[0].toUpperCase() + weatherInfoDescription.substring(1)

        setWeatherData(weatherData)
    }

    private fun setWeatherData(weatherData: WeatherData) {
        val weatherIntent = Intent(this, WeatherActivity::class.java)
        weatherIntent.putExtra("weatherData", weatherData)
        startActivity(weatherIntent)
    }
}
