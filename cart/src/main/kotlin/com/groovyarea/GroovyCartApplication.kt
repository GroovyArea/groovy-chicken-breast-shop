package com.groovyarea

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroovyCartApplication

fun main(args: Array<String>) {
    runApplication<GroovyCartApplication>(*args)
}
