package com.groovyarea.product.infra.db.mongo.repository

import com.groovyarea.global.entity.document.ID
import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.infra.db.mongo.repository.custom.ItemCustomRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ItemRepository :
    ReactiveMongoRepository<Item, ID>,
    ItemCustomRepository {

    fun findByIid(iid: String): Mono<Item>

    fun findAllByCategory(category: ChickenCategories, pageable: Pageable): Flux<Item>
}
