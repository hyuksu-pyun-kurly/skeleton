package com.teseus.skeleton.core.controller.v1.request

import com.teseus.skeleton.core.domain.BoilerplateBusinessInfo

data class BoilerplateRequest(
    val message: String
) {
    fun toBoilerplateInfo(): BoilerplateBusinessInfo {
        return BoilerplateBusinessInfo(message)
    }
}
