package com.teseus.skeleton.client.example

import com.teseus.skeleton.client.example.model.ExampleResult
import com.teseus.skeleton.client.example.model.request.ExampleRequest
import org.springframework.stereotype.Component

@Component
class ExampleClient internal constructor(
    private val exampleProperty: com.teseus.skeleton.client.example.ExampleProperty,
    private val exampleApi: com.teseus.skeleton.client.example.ExampleApi
) {
    fun skeleton(
        skeleton: String
    ): com.teseus.skeleton.client.example.model.ExampleResult {
        val request = com.teseus.skeleton.client.example.model.request.ExampleRequest(
            skeleton = "${exampleProperty.exampleValue}-skeleton"
        )
        return exampleApi.skeleton(request).toResult()
    }
}
