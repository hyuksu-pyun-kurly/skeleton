package com.teseus.skeleton.core.support.error

class ErrorMessage {
    val code: String
    val message: String
    val data: Any?

    constructor(errorType: ErrorType) {
        this.code = errorType.code
        this.message = errorType.message
        this.data = null
    }
    constructor(errorType: ErrorType, data: Any) {
        this.code = errorType.code
        this.message = errorType.message
        this.data = data
    }
}
