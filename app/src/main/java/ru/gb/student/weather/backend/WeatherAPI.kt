package ru.gb.student.weather.backend

interface WeatherAPI {
    fun getWeatherFromServer():WeatherData
    fun getWeatherFromLocalStorage():WeatherData
}