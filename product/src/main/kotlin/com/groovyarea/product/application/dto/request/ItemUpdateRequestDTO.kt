package com.groovyarea.product.application.dto.request

import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.enumerate.ItemStatus

data class ItemUpdateRequestDTO(
    val iid: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val content: String = "",
    val status: ItemStatus = ItemStatus.ON_SALE,
    val category: ChickenCategories,
)
