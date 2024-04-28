package com.groovyarea.cart.domain.service

import com.groovyarea.cart.domain.entity.document.Cart
import com.groovyarea.cart.domain.exception.NOT_FOUND_CART
import com.groovyarea.cart.domain.service.query.CartQueryService
import com.groovyarea.cart.infra.db.mongo.repository.CartRepository
import com.groovyarea.global.exception.NotFoundException
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRepository: CartRepository,
) : CartQueryService {

    override suspend fun getCart(cid: String): Cart {
        return cartRepository.findByCid(cid = cid).awaitSingleOrNull()
            ?: throw NotFoundException(message = NOT_FOUND_CART)
    }
}
