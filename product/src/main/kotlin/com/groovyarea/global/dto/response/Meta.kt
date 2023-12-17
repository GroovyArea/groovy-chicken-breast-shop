package com.groovyarea.global.dto.response

import com.groovyarea.global.model.MetaCode

data class Meta(
    val code: String,
    val type: MetaCode,
    val message: String? = null,
)
