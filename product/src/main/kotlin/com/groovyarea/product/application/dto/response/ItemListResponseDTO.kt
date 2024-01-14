package com.groovyarea.product.application.dto.response

import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.enumerate.ItemStatus

data class ItemListResponseDTO(
    val iid: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val category: ChickenCategories,
    val status: ItemStatus,
)
