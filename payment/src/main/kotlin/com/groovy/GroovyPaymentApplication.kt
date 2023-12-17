package com.groovy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroovyPaymentApplication

fun main(args: Array<String>) {
    runApplication<GroovyPaymentApplication>(*args)
}
