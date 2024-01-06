package com.groovyarea.product.domain.service.query.impl

import com.groovyarea.product.domain.entity.document.Item
import com.groovyarea.product.domain.service.query.ItemQueryService
import com.groovyarea.product.infra.db.mongo.repository.ItemRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class ItemQueryServiceImpl(
    private val itemRepository: ItemRepository,
) : ItemQueryService {

    override suspend fun getItem(
        iid: String
    ): Item? =
        itemRepository.findByIid(iid = iid).awaitSingleOrNull()
}
