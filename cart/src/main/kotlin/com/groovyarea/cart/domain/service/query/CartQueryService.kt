package com.groovyarea.cart.domain.service.query

import com.groovyarea.cart.domain.entity.document.Cart

interface CartQueryService {

    suspend fun getCart(
        cid: String
    ): Cart
}
