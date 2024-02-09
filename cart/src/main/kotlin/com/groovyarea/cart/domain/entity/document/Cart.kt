package com.groovyarea.cart.domain.entity.document

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.groovyarea.global.entity.document.BaseDocument
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Document(collection = "cart")
data class Cart(
    @Indexed
    @Field(name = "cid")
    var cid: String = UUID.randomUUID().toString(),

    @Field(name = "iid")
    var iid: Long,

    @Field(name = "item_name")
    var itemName: String,

    @Field(name = "item_quantity")
    var itemQuantity: Int,

    @Field(name = "total_price")
    var totalPrice: Long
) : com.groovyarea.global.entity.document.BaseDocument()
