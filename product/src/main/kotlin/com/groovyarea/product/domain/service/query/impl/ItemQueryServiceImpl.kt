package com.groovyarea.product.domain.service.query.impl

import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.service.query.ItemQueryService
import com.groovyarea.product.infra.db.mongo.repository.ItemRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ItemQueryServiceImpl(
    private val itemRepository: ItemRepository,
) : ItemQueryService {

    override suspend fun getItem(
        iid: String
    ): Item? =
        itemRepository.findByIid(iid = iid).awaitSingleOrNull()

    override suspend fun getItems(
        pageable: Pageable,
        category: ChickenCategories
    ): List<Item> =
        itemRepository.findAllByCategory(
            category = category,
            pageable = pageable
        )
            .collectList()
            .awaitSingle()

    override suspend fun getSearchedItems(
        itemSearchRequestDTO: ItemSearchRequestDTO,
        category: ChickenCategories,
        pageable: Pageable
    ): List<Item> =
        itemRepository.findAllByDynamicQuery(
            category = category,
            pageable = pageable,
            itemSearchRequestDTO = itemSearchRequestDTO
        )
            .collectList()
            .awaitSingle()
}
