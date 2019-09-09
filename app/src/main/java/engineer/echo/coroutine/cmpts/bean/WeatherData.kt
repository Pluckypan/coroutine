package engineer.echo.coroutine.cmpts.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  WeatherData.kt
 *  Info: 天气数据
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-09 - 10:55
 *  more about me: http://www.1991th.com
 */
@Parcelize
data class WeatherData(
    val date: String,
    val dayPictureUrl: String,
    val nightPictureUrl: String,
    val weather: String,
    val wind: String,
    val temperature: String
) : Parcelable {

}