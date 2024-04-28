package com.groovyarea.cart.domain.entity.document

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.groovyarea.cart.domain.entity.vo.CartItem
import com.groovyarea.global.entity.document.BaseDocument
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Document(collection = "cart")
data class Cart(

    @Indexed(unique = true)
    @Field(name = "uid")
    var uid: String,

    @Indexed
    @Field(name = "cid")
    var cid: String = UUID.randomUUID().toString(),

    @Field(name = "cart_items")
    var items: MutableList<CartItem> = mutableListOf(),
) : BaseDocument()
