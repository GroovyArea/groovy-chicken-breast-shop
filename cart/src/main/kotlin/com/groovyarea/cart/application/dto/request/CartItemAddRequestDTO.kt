package com.groovyarea.cart.application.dto.request

data class CartItemAddRequestDTO(
    val iid: String,
    val quantity: Int,
    val totalPrice: Long
)
