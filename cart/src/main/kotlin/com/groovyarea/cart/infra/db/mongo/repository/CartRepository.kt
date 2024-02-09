package com.groovyarea.cart.infra.db.mongo.repository

import com.groovyarea.cart.domain.entity.document.Cart
import com.groovyarea.global.entity.document.ID
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface CartRepository : ReactiveMongoRepository<Cart, ID> {

    fun findByCid(cid: String): Mono<Cart>
}
