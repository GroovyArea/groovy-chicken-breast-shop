package com.groovyarea.global.exception

import com.groovyarea.global.model.MetaCode

class UnProcessableException(
    message: String? = null,
    data: Any? = null
) : BaseHttpException(
    metaCode = MetaCode.BAD_REQUEST,
    message = message,
    data = data
) {
    constructor(exception: Exception) : this() {
        this.message = exception.message
    }
}
