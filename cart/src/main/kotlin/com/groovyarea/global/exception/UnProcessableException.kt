package com.groovyarea.global.exception

import com.groovyarea.global.model.MetaCode

class UnProcessableException(
    message: String? = null,
    data: Any? = null
) : com.groovyarea.global.exception.BaseHttpException(
    metaCode = MetaCode.BAD_REQUEST,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
