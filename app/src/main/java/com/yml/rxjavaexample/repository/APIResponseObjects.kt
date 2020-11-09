package com.yml.rxjavaexample.repository

import com.google.gson.annotations.SerializedName

data class APIResponseObjects(
//    val postId: Int,
//    val id: Int,
//    val userId: Int,
//    val name: String,
//    val email: String,
//    val title:String,
//    val body: String,
//    val completed: String

    val id: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    val name: String,
    @SerializedName("user_id")
    val userId: Int,
    val description: String,
    val email: String,
    val image: String,
    val price: Long,
    @SerializedName("discount_amount")
    val discountAmount: Long,
    val gender: String,
    val status: String,
    val title: String,
    val body: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)