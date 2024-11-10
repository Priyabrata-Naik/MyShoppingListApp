package com.example.shoppinglistmapapiapp

data class ShoppingItem(
    val id: Int,
    var name: String,
    var quantity: String,
    var isEditing: Boolean = false,
    var address: String = ""
)
