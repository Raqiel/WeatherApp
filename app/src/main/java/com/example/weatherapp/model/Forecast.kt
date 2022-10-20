package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday")
    var ForecastDay: List<ForecastDay>
)
