package com.groovyarea.product.application.dto.request

import com.groovyarea.product.domain.enumerate.ItemStatus

data class ItemSearchRequestDTO(
    val searchKey: String = "name",
    val searchValue: String = "",
    val status: ItemStatus = ItemStatus.ON_SALE,
)
