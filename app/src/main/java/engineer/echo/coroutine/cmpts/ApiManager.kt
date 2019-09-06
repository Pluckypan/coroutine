package engineer.echo.coroutine.cmpts

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


/**
 *  ApiManager.kt
 *  Info: ApiManager OkHttp
 *  Created by Plucky(plucky@echo.engineer) on 2019-09-06 - 17:43
 *  more about me: http://www.1991th.com
 */
object ApiManager {

    private val client by lazy {
        OkHttpClient()
    }
    private val gson by lazy {
        Gson()
    }

    private fun get(url: String): Response {
        return Request.Builder()
            .url(url)
            .build().let {
                client.newCall(it)
            }.execute()
    }

    fun <T> get(url: String, clz: Class<T>): T? {
        val resp = get(url).body?.string() ?: return null
        return gson.fromJson(resp, clz)
    }
}