package com.groovyarea.product.domain.service.query

import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.enumerate.ChickenCategories
import org.springframework.data.domain.Pageable

interface ItemQueryService {

    suspend fun getItem(
        iid: String,
    ): Item?

    suspend fun getItems(
        pageable: Pageable,
        category: ChickenCategories
    ): List<Item>

    suspend fun getSearchedItems(
        itemSearchRequestDTO: ItemSearchRequestDTO,
        category: ChickenCategories,
        pageable: Pageable
    ): List<Item>
}
