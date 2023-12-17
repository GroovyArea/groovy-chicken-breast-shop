package com.groovyarea.global.handler

import com.groovyarea.global.dto.response.Meta
import com.groovyarea.global.dto.response.ResponseDTO
import com.groovyarea.global.exception.BaseHttpException
import com.groovyarea.global.exception.InternalServerException
import com.groovyarea.global.exception.InvalidRequestException
import com.groovyarea.global.exception.NotFoundException
import com.groovyarea.global.exception.UnProcessableException
import com.groovyarea.global.logback.Log
import com.groovyarea.global.model.MetaCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object : Log

    @ExceptionHandler(
        value = [
            (InvalidRequestException::class),
            (NotFoundException::class),
            (InternalServerException::class),
        ]
    )
    @ResponseBody
    fun handleBaseHttpException(
        error: BaseHttpException
    ):
        Mono<ResponseEntity<ResponseDTO<Any>>> {
        val status = when (error) {
            is InvalidRequestException -> HttpStatus.BAD_REQUEST
            is NotFoundException -> HttpStatus.NOT_FOUND
            is InternalServerException -> HttpStatus.INTERNAL_SERVER_ERROR
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }

        return createErrorResponse(statusCode = status, message = error.message, data = error.data)
    }

    @ExceptionHandler(
        value = [
            (Exception::class)
        ]
    )
    fun handleUnhandledException(error: Exception):
        Mono<ResponseEntity<ResponseDTO<Any>>> {
        return createErrorResponse(statusCode = HttpStatus.INTERNAL_SERVER_ERROR, message = error.message)
    }

    @ExceptionHandler(
        value = [
            (NotImplementedError::class)
        ]
    )
    fun handleNotImplementedError(error: NotImplementedError):
        Mono<ResponseEntity<ResponseDTO<Any>>> {
        return createErrorResponse(statusCode = HttpStatus.NOT_IMPLEMENTED, message = error.message)
    }

    @ExceptionHandler(
        value = [
            (UnProcessableException::class)
        ]
    )
    fun handleUnprocessableError(
        error: UnProcessableException
    ):
        Mono<ResponseEntity<ResponseDTO<Any>>> {
        return createErrorResponse(statusCode = HttpStatus.UNPROCESSABLE_ENTITY, message = error.message)
    }

    fun createErrorResponse(
        statusCode: HttpStatus,
        message: String? = null,
        data: Any? = null
    ): Mono<ResponseEntity<ResponseDTO<Any>>> {
        val dtoMetaCode = MetaCode.valueFrom(statusCode)

        val dto = ResponseDTO(
            meta = Meta(
                code = dtoMetaCode.code,
                type = dtoMetaCode,
                message = message
            ),
            data = data
        )

        return Mono.just(ResponseEntity(dto, statusCode))
    }
}
