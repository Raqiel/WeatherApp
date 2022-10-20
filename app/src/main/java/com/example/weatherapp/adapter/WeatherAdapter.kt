package com.example.weatherapp.adapter

import android.database.DataSetObservable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.ForecastDay

class WeatherAdapter(private val dataSet : List <ForecastDay>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){
    class WeatherViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val tvDate : TextView = view.findViewById(R.id.tvLabelDate)
        val tvTempAvg: TextView = view.findViewById(R.id.tvTempAvg)
        val tvTempMin: TextView = view.findViewById(R.id.tvTempMin)
        val tvTempMax: TextView = view.findViewById(R.id.tvTempMax)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_card_item, parent, false)

        return WeatherViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = dataSet[position]
        holder.tvDate.setText(currentItem.Date)
        holder.tvTempAvg.setText(currentItem.Day.AverageTempCelcius.toString())
        holder.tvTempMin.setText(currentItem.Day.MinTempCelsius.toString())
        holder.tvTempMax.setText(currentItem.Day.MaxTempCelcius.toString())

    }

    override fun getItemCount() = dataSet.count()
}