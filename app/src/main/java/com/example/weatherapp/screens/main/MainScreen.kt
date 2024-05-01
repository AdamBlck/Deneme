package com.example.weatherapp.screens.main

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.DataOrException
import com.example.weatherapp.model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    ShowData(mainViewModel = mainViewModel)
}

@Composable
fun ShowData(mainViewModel: MainViewModel){
    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue =DataOrException(loading = true)){
        value =mainViewModel.getWeatherData("")
    }.value
    if (weatherData.loading ==true){
        CircularProgressIndicator()
    }else if (weatherData.data != null){
        Text(text = "Main Screen ${weatherData.data!!.city.country}")
    }

}