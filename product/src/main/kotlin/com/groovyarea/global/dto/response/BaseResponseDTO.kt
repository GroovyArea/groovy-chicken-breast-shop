package com.groovyarea.global.dto.response

open class BaseResponseDTO<T>(
    open val meta: Meta,
    open val data: T? = null,
)
