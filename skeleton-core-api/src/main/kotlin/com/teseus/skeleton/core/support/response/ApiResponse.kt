package com.teseus.skeleton.core.support.response

import com.teseus.skeleton.core.support.error.ErrorMessage
import com.teseus.skeleton.core.support.error.ErrorType

class ApiResponse<S> {
    val result: ResultType
    val data: S?
    val error: ErrorMessage?

    constructor(data: S) {
        this.result = ResultType.SUCCESS
        this.data = data
        this.error = null
    }

    constructor(result: ResultType, data: S?, error: ErrorMessage?) {
        this.result = result
        this.data = data
        this.error = error
    }

    companion object {
        fun <S> success(): ApiResponse<S> {
            return ApiResponse(ResultType.SUCCESS, null, null)
        }

        fun <S> success(result: S): ApiResponse<S> {
            return ApiResponse(ResultType.SUCCESS, result, null)
        }

        fun <S> error(error: ErrorType): ApiResponse<S> {
            return ApiResponse(ResultType.ERROR, null, ErrorMessage(error))
        }

        fun <S> error(error: ErrorType, errorData: Any): ApiResponse<S> {
            return ApiResponse(ResultType.ERROR, null, ErrorMessage(error, errorData))
        }
    }
}
