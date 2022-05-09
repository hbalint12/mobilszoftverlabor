package com.bme.aut.stockdatamonitor.network
import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val url: HttpUrl = originalRequest.url.newBuilder()
      .build()
    Log.d("PATH",url.toString())
    val request = originalRequest.newBuilder().url(originalRequest.url).build()
    return chain.proceed(request)
  }
}