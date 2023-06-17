package com.groovychickenbreashshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus

@SpringBootApplication
class GroovyChickenBreastShopApplication

fun main(args: Array<String>) {
    HttpStatus.BAD_REQUEST
    runApplication<GroovyChickenBreastShopApplication>(*args)
}
