package engineer.echo.coroutine.cmpts.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  WeatherIndex.kt
 *  Info: 天气指数
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-09 - 10:52
 *  more about me: http://www.1991th.com
 */
@Parcelize
data class WeatherIndex(
    val des: String,
    val tipt: String,
    val title: String,
    val zs: String
) : Parcelable {

}