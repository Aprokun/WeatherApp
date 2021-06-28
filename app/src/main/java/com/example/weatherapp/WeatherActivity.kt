package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.weatherapp.weatherinfo.WeatherData
import org.w3c.dom.Text
import java.util.*

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        supportActionBar?.hide()

        val weatherData = intent.extras?.get("weatherData") as WeatherData

        setWeatherDataFields(weatherData)
    }

    private fun setWeatherDataFields(data: WeatherData) {
        val weatherName = findViewById<TextView>(R.id.weather_name)
        val temperatureField = findViewById<TextView>(R.id.temp_field)
        val temperatureFeelsLikeField = findViewById<TextView>(R.id.temp_feels_like_field)
        val windSpeedField = findViewById<TextView>(R.id.wind_speed_field)
        val pressureField = findViewById<TextView>(R.id.pressure_field)
        val visibilityField = findViewById<TextView>(R.id.visibility_field)

        weatherName.text = data.weather[0].description
        temperatureField.text = (data.main.temp.toString() + " C")
        temperatureFeelsLikeField.text = (data.main.feels_like.toString() + " C")
        windSpeedField.text = (data.wind.speed.toString() + " м/с")
        pressureField.text = (data.main.pressure.toString() + " Па")
        visibilityField.text = data.visibility.toString()
    }
}