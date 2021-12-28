package ru.gb.student.weather.Backend

interface WeatherAPI {
    fun getWeatherFromServer():WeatherData
    fun getWeatherFromLocalStorage():WeatherData
}