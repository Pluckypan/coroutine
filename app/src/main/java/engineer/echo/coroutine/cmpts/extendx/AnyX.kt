package engineer.echo.coroutine.cmpts.extendx

import com.google.gson.Gson
import engineer.echo.coroutine.cmpts.C

/**
 *  AnyX.kt
 *  Info: 任意对象的扩展
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-06 - 19:04
 *  more about me: http://www.1991th.com
 */

/**
 * 返回内存标识（不代表内存地址）
 */
fun Any.memInfo(): Int {
    return System.identityHashCode(this)
}

/**
 * 返回类标识
 */
val Any.TAG: String
    get() = this.javaClass.simpleName

/**
 * 拼接天气请求地址
 */
fun String.weatherUrl(): String =
    "http://api.map.baidu.com/telematics/v3/weather?output=json&ak=${C.AK}&&location=$this"

/**
 * 当前环境线程
 */
fun Any.currentThread(): String = Thread.currentThread().name

/**
 * json 转换
 */
inline fun <reified T> Gson.convertTo(json: String): T = fromJson(json, T::class.java)
