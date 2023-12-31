package com.groovyarea.global.dto.response

import com.groovyarea.global.model.MetaCode
import org.springframework.http.HttpStatus

data class ResponseDTO<T>(
    val meta: Meta,
    val data: T? = null,
) {
    companion object {
        fun <T> success(meta: Meta, data: T? = null): ResponseDTO<T> = ResponseDTO(meta, data)
        fun <T> success(metaCode: MetaCode, data: T? = null): ResponseDTO<T> = success(
            Meta(code = metaCode.code, type = metaCode),
            data
        )
        fun <T> success(data: T? = null): ResponseDTO<T> = success(MetaCode.SUCCESS, data)

        fun errorResponse(status: HttpStatus, errorMessage: String?): ResponseDTO<Nothing> {
            val metaCode = MetaCode.valueFrom(status)
            return ResponseDTO(
                data = null,
                meta = Meta(
                    code = metaCode.code,
                    type = metaCode,
                    message = errorMessage
                ),
            )
        }
    }
}
