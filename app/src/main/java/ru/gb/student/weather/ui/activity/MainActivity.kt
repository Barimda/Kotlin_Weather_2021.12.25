package ru.gb.student.weather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ru.gb.student.weather.ui.viewModel.AppState
import ru.gb.student.weather.databinding.ActivityMainBinding
import ru.gb.student.weather.ui.fragments.ShowWeatherFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainUI: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUI = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainUI.root)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(mainUI.mainFrame.id, ShowWeatherFragment.newInstance()).commit()

        Snackbar.make(mainUI.mainFrame, "App is Started",Snackbar.LENGTH_LONG).show()
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