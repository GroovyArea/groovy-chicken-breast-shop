package com.groovyarea.product.infra.db.mongo.repository

import com.groovyarea.global.entity.document.ID
import com.groovyarea.product.domain.entity.document.Category
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CategoryRepository : ReactiveMongoRepository<Category, ID>
