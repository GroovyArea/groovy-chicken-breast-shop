package com.groovyarea.product.infra.db.mongo.repository.custom.impl

import com.groovyarea.global.exception.InvalidRequestException
import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.infra.db.mongo.repository.custom.ItemCustomRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import kotlin.reflect.full.memberProperties

@Repository
class ItemCustomRepositoryImpl(
    private val reactiveMongoTemplate: ReactiveMongoTemplate,
) : ItemCustomRepository {

    override fun findAllByDynamicQuery(
        pageable: Pageable,
        category: ChickenCategories,
        itemSearchRequestDTO: ItemSearchRequestDTO
    ): Flux<Item> {
        val query = Query()
            .addCriteria(Criteria.where("category").`is`(category))
            .addCriteria(searchDTOConditionEq(itemSearchRequestDTO))
            .addCriteria(Criteria.where("status").`is`(itemSearchRequestDTO.status))
            .skip((pageable.pageNumber * pageable.pageSize).toLong())
            .limit(pageable.pageSize)

        return reactiveMongoTemplate.find(query, Item::class.java)
    }

    private fun searchDTOConditionEq(searchDTO: ItemSearchRequestDTO): Criteria {
        val itemFields = Item::class.memberProperties.map { it.name }
        if (itemFields.contains(searchDTO.searchKey)) {
            return Criteria.where(searchDTO.searchKey).`is`(searchDTO.searchValue)
        }
        throw InvalidRequestException(message = "유효하지 않은 검색 조건 : " + searchDTO.searchKey)
    }
}
