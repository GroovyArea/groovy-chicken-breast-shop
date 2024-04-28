package com.groovyarea.cart.application.dto.response

data class CartItemListResponseDTO(
    val items: List<CartItem>,
) {

    data class CartItem(
        val iid: String,
        val itemName: String,
        val itemQuantity: Int,
        val totalPrice: Long
    )
}
