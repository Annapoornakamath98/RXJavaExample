package com.yml.rxjavaexample.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {
    private val retrofit: Retrofit by lazy{
        val okHttpClient = OkHttpClient.Builder().build()
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
        addConverterFactory(GsonConverterFactory.create()).
        addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
        client(okHttpClient).
        build()
    }
    fun getRetrofitInstance():Retrofit{
        return retrofit
    }

}
//val okHttpClient = OkHttpClient.Builder().build()
//https://gorest.co.in/
//Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
//addConverterFactory(GsonConverterFactory.create()).
//client(okHttpClient).
//build()