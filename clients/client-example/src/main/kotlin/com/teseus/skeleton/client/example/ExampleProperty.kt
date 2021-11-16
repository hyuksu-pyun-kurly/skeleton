package com.teseus.skeleton.client.example

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "example.api")
internal data class ExampleProperty(
    val exampleValue: String
)
