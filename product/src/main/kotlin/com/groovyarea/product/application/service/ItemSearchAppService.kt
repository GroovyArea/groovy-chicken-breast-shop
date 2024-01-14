package com.groovyarea.product.application.service

import com.groovyarea.global.exception.NotFoundException
import com.groovyarea.global.pagination.dto.PageDTO
import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.application.dto.response.ItemDetailResponseDTO
import com.groovyarea.product.application.dto.response.ItemListResponseDTO
import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.exception.ITEM_NOT_FOUND
import com.groovyarea.product.domain.mapper.ItemMapper
import com.groovyarea.product.domain.service.query.ItemQueryService
import org.springframework.stereotype.Service

@Service
class ItemSearchAppService(
    private val itemQueryService: ItemQueryService,
) {

    suspend fun getItem(
        iid: String
    ): ItemDetailResponseDTO {
        val item = itemQueryService.getItem(iid = iid)
            ?: throw NotFoundException(message = ITEM_NOT_FOUND)

        return ItemMapper.INSTANCE.convertToItemDetailResponseDTO(
            item = item
        )
    }

    suspend fun getItems(
        category: ChickenCategories,
        pageDTO: PageDTO,
    ): List<ItemListResponseDTO> {
        val items = itemQueryService.getItems(
            pageable = pageDTO,
            category = category
        )

        return items.map {
            ItemMapper.INSTANCE.convertToItemListResponseDTO(it)
        }
    }

    suspend fun getSearchedItems(
        itemSearchRequestDTO: ItemSearchRequestDTO,
        category: ChickenCategories,
        pageDTO: PageDTO
    ): List<ItemListResponseDTO> {
        val items = itemQueryService.getSearchedItems(
            itemSearchRequestDTO = itemSearchRequestDTO,
            pageable = pageDTO,
            category = category
        )

        return items.map {
            ItemMapper.INSTANCE.convertToItemListResponseDTO(it)
        }
    }
}
