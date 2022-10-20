package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("maxtemp_c")
    var MaxTempCelcius: Float,
    @SerializedName("mintemp_c")
    var MinTempCelsius: Float,
    @SerializedName("avgtemp_c")
    var AverageTempCelcius:Float


)
