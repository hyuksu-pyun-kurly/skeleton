package com.teseus.skeleton.client.example.model.response

import com.teseus.skeleton.client.example.model.ExampleResult

internal data class BoilerplateResponse(
    val skeleton: String
) {
    fun toResult(): com.teseus.skeleton.client.example.model.ExampleResult {
        return com.teseus.skeleton.client.example.model.ExampleResult(skeleton)
    }
}
