package com.example.cs310_hw2.data

data class NewsCategoryByIdResponse(
    val serviceMessageCode :Int,
    val serviceMessageText :String,
    val items:ArrayList<NewsCategoryByIdItem>
)

data class NewsCategoryByIdItem(
    val id: Int,
    val title: String,
    val text: String,
    val date: String,
    val image: String,
    val categoryName: String
)
