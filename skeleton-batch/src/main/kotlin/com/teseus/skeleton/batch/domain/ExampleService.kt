package com.teseus.skeleton.batch.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ExampleService(
    private val exampleLogic: ExampleLogic
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun skeleton(skeletonLogicCode: String): ExampleLogicResult {
        logger.info("GO EX")
        return exampleLogic.logic()
    }
}
