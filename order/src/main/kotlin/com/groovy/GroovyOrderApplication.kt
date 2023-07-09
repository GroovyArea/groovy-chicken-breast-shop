package com.groovy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroovyOrderApplication {
}

fun main(args: Array<String>) {
    runApplication<GroovyOrderApplication>(*args)
}