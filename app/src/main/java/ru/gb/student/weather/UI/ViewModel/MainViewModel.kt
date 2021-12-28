package ru.gb.student.weather.UI.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gb.student.weather.Backend.WeatherAPIRequester
import java.lang.Thread.sleep

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val weatherAPIRequester: WeatherAPIRequester = WeatherAPIRequester()
) : ViewModel() {

    fun getLiveData(): LiveData<AppState> {
        return liveData
    }

    fun getWeatherFromServer() {
        liveData.postValue(AppState.Loading(0))
        Thread {
            sleep(1000)
            val rand = (1..40).random()
            if (rand > 20) {
                liveData.postValue(AppState.Success(weatherAPIRequester.getWeatherFromServer().toString()))
            } else {
                liveData.postValue(AppState.Error(IllegalStateException("")))
            }

        }.start()
    }

    fun getWeather() {
        // TODO Добавить переключатель
        getWeatherFromServer()
    }

}