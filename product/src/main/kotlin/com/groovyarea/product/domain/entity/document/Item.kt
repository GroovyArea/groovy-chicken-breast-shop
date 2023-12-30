package com.groovyarea.product.domain.entity.document

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.groovyarea.global.entity.document.BaseDocument
import com.groovyarea.product.domain.enumerate.ItemStatus
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Document(collection = "item")
data class Item(
    @Field(name = "name")
    var name: String,

    @Field(name = "price")
    var price: Int,

    @Field(name = "quantity")
    var quantity: Int,

    @Field(name = "content")
    var content: String,

    @Field(name = "status")
    var status: ItemStatus,

    @Field(name = "iid")
    var iid: String,

    @Field(name = "cid")
    var cid: String,
) : BaseDocument()
