package com.teseus.skeleton.core.domain

import com.teseus.skeleton.client.example.ExampleClient
import org.springframework.stereotype.Service

@Service
class BoilerplateService(
    val exampleClient: com.teseus.skeleton.client.example.ExampleClient
) {
    fun skeleton(skeleton: BoilerplateBusinessInfo): BoilerplateBusinessResult {
        val result = exampleClient.skeleton(skeleton.message)
        return BoilerplateBusinessResult(result.skeletonResult)
    }
}
