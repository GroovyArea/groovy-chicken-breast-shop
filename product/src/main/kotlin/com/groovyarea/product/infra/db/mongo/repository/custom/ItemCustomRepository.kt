package com.groovyarea.product.infra.db.mongo.repository.custom

import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.enumerate.ChickenCategories
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Flux

interface ItemCustomRepository {

    fun findAllByDynamicQuery(
        pageable: Pageable,
        category: ChickenCategories,
        itemSearchRequestDTO: ItemSearchRequestDTO
    ): Flux<Item>
}
