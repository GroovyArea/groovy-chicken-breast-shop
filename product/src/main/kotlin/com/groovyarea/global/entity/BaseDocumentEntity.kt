package com.groovyarea.global.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.time.LocalDateTime

open class BaseDocumentEntity {

    @Id
    @Field("_id", targetType = FieldType.OBJECT_ID)
    var objectId: String? = null

    @Field("created_at")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Field("updated_at")
    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
