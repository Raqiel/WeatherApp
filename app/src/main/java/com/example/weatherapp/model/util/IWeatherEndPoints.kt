package com.example.weatherapp.model.util

import com.example.weatherapp.model.WeatherForecastResult
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IWeatherEndPoints {
    @Headers(
        "X-RapidAPI-Host:weatherapi-com.p.rapidapi.com",
        "X-RapidAPI-Key:463c34412cmsh4569459a7e1c758p1cc025jsn8c26951c3229"
    )
    @GET("forecast.json")
    fun requestWeatherForecast(@Query("q") city : String, @Query("days") numberOfDays: Int) : Maybe<WeatherForecastResult>
}