package com.groovyarea.product.application.dto.response

import com.groovyarea.product.domain.enumerate.ChickenCategories
import java.time.LocalDateTime

data class ItemDetailResponseDTO(
    val iid: String,
    val name: String,
    val category: ChickenCategories,
    val price: Int,
    val quantity: Int,
    val content: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
