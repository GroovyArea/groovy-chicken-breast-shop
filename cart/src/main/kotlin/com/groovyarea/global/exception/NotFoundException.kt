package com.groovyarea.global.exception

import com.groovyarea.global.model.MetaCode

class NotFoundException(
    message: String? = null,
    data: Any? = null
) : com.groovyarea.global.exception.BaseHttpException(
    metaCode = MetaCode.NOT_FOUND,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
