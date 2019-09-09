package engineer.echo.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import engineer.echo.coroutine.cmpts.ApiManager
import engineer.echo.coroutine.cmpts.bean.WeatherResp
import engineer.echo.coroutine.cmpts.extendx.TAG
import engineer.echo.coroutine.cmpts.extendx.weatherUrl
import engineer.echo.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *  MainActivity.kt
 *  Info: MainActivity.kt
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-06 - 19:02
 *  more about me: http://www.1991th.com
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            date = MutableLiveData()
            // setup lifecycleOwner for LiveData
            lifecycleOwner = this@MainActivity
        }
        getWeather()
    }

    private fun getWeather() {
        GlobalScope.launch {
            val result = async {
                ApiManager.get("beijing".weatherUrl(), WeatherResp::class.java)
            }
            val weather = result.await()
            binding.city = weather?.results?.firstOrNull()?.currentCity
            // in work thread,so post value
            binding.date?.postValue(weather?.date)
            Log.d(this@MainActivity.TAG, "weather:${weather?.status}")
        }
    }
}
