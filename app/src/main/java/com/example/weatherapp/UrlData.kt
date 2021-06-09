package com.example.weatherapp

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class UrlData : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String?): String {
        val conn: HttpURLConnection
        val reader: BufferedReader

        try {
            val url = URL(params[0])
            conn = url.openConnection() as HttpURLConnection
            conn.connect()

            val stream = conn.inputStream
            reader = BufferedReader(InputStreamReader(stream))

            val builder = StringBuilder()
            var line = reader.readLine()

            while (line != null) {
                builder.append(line).append("\n")
                line = reader.readLine()
            }

            return builder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }
}