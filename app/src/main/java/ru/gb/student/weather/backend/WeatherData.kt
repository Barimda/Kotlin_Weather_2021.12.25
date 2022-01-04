package ru.gb.student.weather.backend

data class WeatherData(val city:CityData = getDefaultCity(), val temperature:Int = 20, val feelsLike:Int = 22)
data class CityData(val name:String, val lon:Double, val lat:Double)

fun getDefaultCity() = CityData("Moscow", 37.5, 55.5)