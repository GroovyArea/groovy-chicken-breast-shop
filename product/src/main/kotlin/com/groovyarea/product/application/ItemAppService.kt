package com.groovyarea.product.application

import com.groovyarea.global.exception.NotFoundException
import com.groovyarea.product.application.dto.response.ItemDetailResponseDTO
import com.groovyarea.product.domain.exception.ITEM_NOT_FOUND
import com.groovyarea.product.domain.mapper.ItemMapper
import com.groovyarea.product.domain.service.query.ItemQueryService
import org.springframework.stereotype.Service

@Service
class ItemAppService(
    private val itemQueryService: ItemQueryService,
) {

    suspend fun getItem(
        iid: String
    ): ItemDetailResponseDTO {
        val item = (
            itemQueryService.getItem(iid = iid)
                ?: throw NotFoundException(message = ITEM_NOT_FOUND)
            )
        return ItemMapper.INSTANCE.convertToItemDetailResponseDTO(
            item = item
        )
    }
}
