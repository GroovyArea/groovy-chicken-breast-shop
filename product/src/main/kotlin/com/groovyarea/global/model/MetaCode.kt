package com.groovyarea.global.model

import org.springframework.http.HttpStatus

enum class MetaCode(var code: String) {
    SUCCESS("20000000"),
    CREATED("20100000"),
    ACCEPTED("20200000"),
    NO_CONTENT("20400000"),
    BAD_REQUEST("40000000"),
    AUTHENTICATION_FAILED("40100000"),
    FORBIDDEN("40300000"),
    NOT_FOUND("40400000"),
    METHOD_NOW_ALLOWED("40500000"),
    NOT_ACCEPTABLE("40600000"),
    CONFLICT("40900000"),
    UNSUPPORTED_MEDIA_TYPE("41500000"),
    UNPROCESSABLE_ENTITY("42200000"),
    THROTTLED("42900000"),
    INTERNAL_SERVER_ERROR("50000000"),
    NOT_IMPLEMENTED("50100000"),
    SERVICE_UNAVAILABLE("50300000");

    companion object {
        fun valueFrom(status: HttpStatus) = when (status) {
            HttpStatus.OK -> SUCCESS
            HttpStatus.NO_CONTENT -> NO_CONTENT
            HttpStatus.CREATED -> CREATED
            HttpStatus.BAD_REQUEST -> BAD_REQUEST
            HttpStatus.NOT_FOUND -> NOT_FOUND
            HttpStatus.CONFLICT -> CONFLICT
            HttpStatus.NOT_IMPLEMENTED -> NOT_IMPLEMENTED
            HttpStatus.INTERNAL_SERVER_ERROR -> INTERNAL_SERVER_ERROR
            HttpStatus.SERVICE_UNAVAILABLE -> SERVICE_UNAVAILABLE
            HttpStatus.UNPROCESSABLE_ENTITY -> UNPROCESSABLE_ENTITY
            else -> throw IllegalArgumentException("Please provide correct status.")
        }
    }
}
