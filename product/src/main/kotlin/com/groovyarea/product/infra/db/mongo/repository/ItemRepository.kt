package com.groovyarea.product.infra.db.mongo.repository

import com.groovyarea.global.entity.document.ID
import com.groovyarea.product.domain.entity.document.Item
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface ItemRepository : ReactiveMongoRepository<Item, ID> {

    fun findByIid(iid: String): Mono<Item>
}
