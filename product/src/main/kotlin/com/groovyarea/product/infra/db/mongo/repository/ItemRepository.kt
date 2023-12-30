package com.groovyarea.product.infra.db.mongo.repository

import com.groovyarea.global.entity.document.ID
import com.groovyarea.product.domain.entity.document.Item
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ItemRepository : ReactiveMongoRepository<Item, ID>
