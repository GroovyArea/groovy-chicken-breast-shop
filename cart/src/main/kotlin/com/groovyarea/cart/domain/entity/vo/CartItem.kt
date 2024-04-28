package com.groovyarea.cart.domain.entity.vo

data class CartItem(
    var iid: String,
    var itemName: String,
    var itemQuantity: Int,
    var totalPrice: Long,
)
