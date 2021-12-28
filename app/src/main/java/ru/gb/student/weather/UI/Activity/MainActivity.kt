package ru.gb.student.weather.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.gb.student.weather.R
import ru.gb.student.weather.UI.Fragments.WeatherNowFragment
import ru.gb.student.weather.UI.ViewModel.AppState
import ru.gb.student.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainUI: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUI = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainUI.root)

        if (savedInstanceState == null)
//            Будет ли следующий код валидным??
//            supportFragmentManager.beginTransaction().replace(mainUI.mainFrame.id, WeatherNowFragment.newInstance())
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, WeatherNowFragment.newInstance())

    }

    fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> Toast.makeText(this, appState.error.message, Toast.LENGTH_LONG)
                .show()
            is AppState.Loading -> Toast.makeText(this, appState.progress, Toast.LENGTH_LONG).show()
            is AppState.Success -> Toast.makeText(this, appState.weatherData, Toast.LENGTH_LONG)
                .show()

        }
    }
}