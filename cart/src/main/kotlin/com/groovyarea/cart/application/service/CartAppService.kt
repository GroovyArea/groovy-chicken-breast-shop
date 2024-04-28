package com.groovyarea.cart.application.service

import com.groovyarea.cart.application.dto.response.CartItemListResponseDTO
import com.groovyarea.cart.domain.service.CartService
import com.groovyarea.cart.infra.db.mongo.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class CartAppService(
    private val cartService: CartService,
    private val cartRepository: CartRepository,
) {

    suspend fun getCartDetail(
        uid: String,
        cid: String,
    ): CartItemListResponseDTO {
        val cart = cartService.getCart(cid = cid)

        val cartDetails = cart.items.map {
            CartItemListResponseDTO.CartItem(
                iid = it.iid,
                itemName = it.itemName,
                itemQuantity = it.itemQuantity,
                totalPrice = it.totalPrice
            )
        }

        return CartItemListResponseDTO(
            items = cartDetails
        )
    }
}
