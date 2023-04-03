package com.example.cs310_hw2.remote

import com.example.cs310_hw2.data.NewsCategoryByIdResponse
import com.example.cs310_hw2.data.NewsCategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Apiservice {

    @GET("getallnewscategories")
    fun getAllNewsCategories(): Call<NewsCategoryResponse>

    @GET("getbycategoryid/{id}")
    fun getByCategoryId(@Path("id") id: Int): Call<NewsCategoryByIdResponse>

    // Kotlin companion Object
    companion object {

        var BASE_URL = "http://10.3.0.14:8080/newsapp/"

        fun create() : Apiservice {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(Apiservice::class.java)

        }
    }
}