package com.groovy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroovyProductApplication {
}

fun main(args: Array<String>) {
    runApplication<GroovyProductApplication>(*args)
}