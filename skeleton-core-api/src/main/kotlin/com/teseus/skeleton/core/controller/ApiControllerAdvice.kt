package com.teseus.skeleton.core.controller

import com.teseus.skeleton.core.support.error.ErrorType
import com.teseus.skeleton.core.support.response.ApiResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        logger.error("Exception : {}", e.message, e)
        return ResponseEntity(ApiResponse.error(ErrorType.COMMON_ERROR), ErrorType.COMMON_ERROR.status)
    }
}
