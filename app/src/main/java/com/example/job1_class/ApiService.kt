package com.example.job1_class

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts():List<Product>
}