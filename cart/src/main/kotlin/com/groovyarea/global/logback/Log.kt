package com.groovyarea.global.logback

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object HttpLog {
    const val REQUEST_ID = "request-id"
    const val REMOTE_SERVICE = "remote-service"
    const val METHOD = "method"
    const val URL = "url"
    const val HEADERS = "headers"
    const val PARAMETERS = "parameters"
    const val CONTENT_TYPE = "content-type"
    const val REQUEST = "request"
    const val RESPONSE = "response"
    const val STATUS = "status"
    const val X_REQUEST_ID = "x-request-id"
}

interface Log {

    val logger: Logger get() = LoggerFactory.getLogger(this.javaClass)
}
