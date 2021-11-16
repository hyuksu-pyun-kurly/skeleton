package com.teseus.skeleton.core.support.error

import org.springframework.http.HttpStatus

enum class ErrorType(val status: HttpStatus, val code: String, val message: String) {
    COMMON_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "1000", "처리 중 오류가 발생했습니다")
}
