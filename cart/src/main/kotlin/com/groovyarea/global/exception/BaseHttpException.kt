package com.groovyarea.global.exception

import com.groovyarea.global.model.MetaCode

open class BaseHttpException(
    val metaCode: MetaCode = MetaCode.INTERNAL_SERVER_ERROR,
    override var message: String? = null,
    val data: Any? = null
) : RuntimeException()
