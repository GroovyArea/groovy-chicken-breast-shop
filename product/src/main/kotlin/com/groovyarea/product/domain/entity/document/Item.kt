package com.groovyarea.product.domain.entity.document

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.groovyarea.global.entity.document.BaseDocument
import com.groovyarea.product.domain.enumerate.ChickenCategories
import com.groovyarea.product.domain.enumerate.ItemStatus
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

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
    var status: ItemStatus = ItemStatus.ON_SALE,

    @Indexed
    @Field(name = "iid")
    var iid: String = UUID.randomUUID().toString(),

    @Indexed
    @Field(name = "category")
    var category: ChickenCategories,
) : BaseDocument() {

    suspend fun delete() {
        this.status = ItemStatus.EXTINCTION
    }
}
