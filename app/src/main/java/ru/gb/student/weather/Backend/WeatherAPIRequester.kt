package ru.gb.student.weather.Backend

class WeatherAPIRequester : WeatherAPI{
    override fun getWeatherFromServer(): WeatherData {
        return WeatherData()
    }

    override fun getWeatherFromLocalStorage(): WeatherData {
        return WeatherData()
    }

}