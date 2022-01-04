package ru.gb.student.weather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import ru.gb.student.weather.ui.fragments.WeatherNowFragment
import ru.gb.student.weather.ui.viewModel.AppState
import ru.gb.student.weather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainUI: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUI = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainUI.root)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(mainUI.mainFrame.id, WeatherNowFragment.newInstance()).commit()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frame, WeatherNowFragment.newInstance()).commit()

    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(mainUI.toolbar.id, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

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