package com.yml.rxjavaexample.repository

data class Pagination (
    val total: Int,
    val pages:Int,
    val page: Int,
    val limit:Int
)