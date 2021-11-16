package com.teseus.skeleton.client.example

import com.teseus.skeleton.client.example.model.request.ExampleRequest
import com.teseus.skeleton.client.example.model.response.BoilerplateResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "example-api", url = "\${example.api.url}")
internal interface ExampleApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/skeleton/skeleton-api"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun skeleton(@RequestBody request: com.teseus.skeleton.client.example.model.request.ExampleRequest): com.teseus.skeleton.client.example.model.response.BoilerplateResponse
}
