package com.groovyarea.global.dto.response

import com.groovyarea.global.model.MetaCode

data class Meta(
    val type: MetaCode,
    val code: String = type.code,
    val message: String? = null,
)
