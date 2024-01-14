package com.groovyarea.product.application.service

import com.groovyarea.global.exception.NotFoundException
import com.groovyarea.product.application.dto.request.ItemRegisterRequestDTO
import com.groovyarea.product.application.dto.request.ItemUpdateRequestDTO
import com.groovyarea.product.domain.exception.ITEM_NOT_FOUND
import com.groovyarea.product.domain.mapper.ItemMapper
import com.groovyarea.product.infra.db.mongo.repository.ItemRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class ItemCrudAppService(
    private val itemRepository: ItemRepository,
) {

    suspend fun register(
        itemRegisterRequestDTO: ItemRegisterRequestDTO,
    ) {
        val item = ItemMapper.INSTANCE.convertToItem(
            itemRegisterRequestDTO = itemRegisterRequestDTO
        )
        itemRepository.save(item).awaitSingle()
    }

    suspend fun update(
        itemUpdateRequestDTO: ItemUpdateRequestDTO,
    ) {
        val savedItem = itemRepository.findByIid(iid = itemUpdateRequestDTO.iid).awaitSingleOrNull()
            ?: throw NotFoundException(message = ITEM_NOT_FOUND)

        savedItem.apply {
            name = itemUpdateRequestDTO.name
            price = itemUpdateRequestDTO.price
            quantity = itemUpdateRequestDTO.quantity
            content = itemUpdateRequestDTO.content
            status = itemUpdateRequestDTO.status
            category = itemUpdateRequestDTO.category
        }

        itemRepository.save(savedItem).awaitSingle()
    }

    suspend fun delete(
        iid: String
    ) {
        val savedItem = itemRepository.findByIid(iid = iid).awaitSingleOrNull()
            ?: throw NotFoundException(message = ITEM_NOT_FOUND)

        savedItem.delete()

        itemRepository.save(savedItem).awaitSingle()
    }
}
