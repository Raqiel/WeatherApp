package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapter.WeatherAdapter
import com.example.weatherapp.model.util.Constants
import com.example.weatherapp.model.util.Constants.Companion.WEATHER_API_BASE_URL
import com.example.weatherapp.model.util.IWeatherEndPoints
import com.example.weatherapp.model.util.NetWorkUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class MainActivity : AppCompatActivity() {
    lateinit var rvWeather : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvWeather = findViewById(R.id.rvWeather)

        searchForecast("Betim")
    }

    private fun searchForecast(city : String) {
        val network = NetWorkUtils.getRetrofitInstance(Constants.WEATHER_API_BASE_URL)
        val endpoint = network.create(IWeatherEndPoints::class.java)

        endpoint.requestWeatherForecast(city, 3)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val weatherData = it.forecast.ForecastDay
                rvWeather.adapter = WeatherAdapter(weatherData)
            },
                {
                    Log.d(localClassName, "Error ${it.message}")
                })

    }
}


