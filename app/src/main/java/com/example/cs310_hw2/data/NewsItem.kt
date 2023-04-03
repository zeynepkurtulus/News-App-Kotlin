package com.example.cs310_hw2.data

data class NewsCategoryResponse(
    val serviceMessageCode :Int,
    val serviceMessageText :String,
    val items:ArrayList<NewsCategoryItem>
)

data class NewsCategoryItem(
    val id: Int,
    val name: String
)
