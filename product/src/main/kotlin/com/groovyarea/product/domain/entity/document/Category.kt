package com.groovyarea.product.domain.entity.document

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.groovyarea.global.entity.document.BaseDocument
import com.groovyarea.product.domain.enumerate.ChickenCategories
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Document(collection = "category")
class Category(

    @Field(name = "cid")
    var cid: String,

    @Field(name = "name")
    var categoryName: ChickenCategories,
) : BaseDocument()
