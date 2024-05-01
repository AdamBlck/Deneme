package com.example.weatherapp.network

import com.example.weatherapp.model.Weather
import com.example.weatherapp.model.WeatherObject
import com.example.weatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherApi {
    @GET("2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") unit: String = "imperial",
        @Query("appid") appid :String =Constants.API_KEY
    ) :Weather
}