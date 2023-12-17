package com.groovyarea.product.application.rest

import com.groovyarea.global.constant.VERSION
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    suspend fun index(): String = "Groovy-Product $VERSION"
}
