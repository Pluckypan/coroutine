package engineer.echo.coroutine.cmpts.bean

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *  Weather.kt
 *  Info: 天气
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-09 - 10:51
 *  more about me: http://www.1991th.com
 */
@Parcelize
data class Weather(
    val currentCity: String,
    val pm25: String,
    val index: List<WeatherIndex>,
    @SerializedName("weather_data")
    val weatherData: List<WeatherData>
) : Parcelable {

}