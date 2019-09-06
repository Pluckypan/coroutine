package engineer.echo.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import engineer.echo.coroutine.cmpts.ApiManager
import engineer.echo.coroutine.cmpts.bean.WeatherResp
import engineer.echo.coroutine.cmpts.extendx.TAG
import engineer.echo.coroutine.cmpts.extendx.weatherUrl
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWeather()
    }

    private fun getWeather() {
        GlobalScope.launch {
            val result = async {
                ApiManager.get("beijing".weatherUrl(), WeatherResp::class.java)
            }
            val weather = result.await()
            Log.d(this@MainActivity.TAG, "weather:${weather?.status}")
        }
    }
}
