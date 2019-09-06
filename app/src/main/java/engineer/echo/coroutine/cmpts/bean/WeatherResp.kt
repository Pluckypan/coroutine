package engineer.echo.coroutine.cmpts.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  WeatherResp.kt
 *  Info: 天气接口实体
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-06 - 19:50
 *  more about me: http://www.1991th.com
 */
@Parcelize
data class WeatherResp(
    val error: Int,
    val status: String,
    val date: String
) : Parcelable