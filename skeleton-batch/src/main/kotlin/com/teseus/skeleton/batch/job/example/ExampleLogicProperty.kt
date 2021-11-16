package com.teseus.skeleton.batch.job.example

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "example")
data class ExampleLogicProperty(
    val exampleLogicCode: String
)
