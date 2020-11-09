package com.yml.rxjavaexample.repository

interface APIResponseInterface {
    fun onResponse(response: List<APIResponseObjects>)
    fun onFailure(t:Throwable)
}