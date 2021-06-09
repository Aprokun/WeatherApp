package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun setArea(v: View?) {
        val area = findViewById<EditText>(R.id.area_field).text.toString()
        val uri =
            "http://api.openweathermap.org/data/2.5/weather?q=$area&APPID=2a619a56722bfe49e858f019625aa9a1&units=metric&lang=ru"
        val url = URL(uri)

        val jsonString = getJsonString(url)
    }

    private fun getJsonString(url: URL) : String {
        return try {
            val strBldr = StringBuilder()

            val buffer = BufferedReader(InputStreamReader(url.openStream()))
            var line = buffer.readLine()

            while (line != null) {
                strBldr.append(line).append("\n")
                line = buffer.readLine()
            }

            strBldr.toString()
        } catch (e: Exception) {
            null.toString()
        }
    }
}
