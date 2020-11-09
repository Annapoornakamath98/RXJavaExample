package com.yml.rxjavaexample.repository

import com.yml.rxjavaexample.repository.APIResponseObjects
import io.reactivex.Observable
import retrofit2.http.GET

interface APIResponse {
    @GET("posts")
    fun getPosts(): Observable<List<APIResponseObjects>>

    @GET("comments")
    fun getComments(): Observable<List<APIResponseObjects>>

//    @GET("/public-api/posts")
//    fun getPosts(): Observable<List<Data>>
}