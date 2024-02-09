package com.groovyarea.global.exception

import com.groovyarea.global.model.MetaCode

class InternalServerException(
    message: String? = null,
    data: Any? = null
) : com.groovyarea.global.exception.BaseHttpException(
    metaCode = MetaCode.INTERNAL_SERVER_ERROR,
    message = message,
    data = data
)
