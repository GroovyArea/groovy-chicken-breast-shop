package com.groovyarea.product.application.dto.request

import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.enumerate.ItemStatus

data class ItemRegisterRequestDTO(
    val name: String,
    val price: Int,
    val quantity: Int,
    val content: String,
    val status: ItemStatus,
    val category: ChickenCategories,
)
