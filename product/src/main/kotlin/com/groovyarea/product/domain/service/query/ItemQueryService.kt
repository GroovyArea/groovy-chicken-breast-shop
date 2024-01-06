package com.groovyarea.product.domain.service.query

import com.groovyarea.product.domain.entity.document.Item

interface ItemQueryService {

    suspend fun getItem(
        iid: String,
    ): Item?
}
