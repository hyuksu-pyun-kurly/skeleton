package com.teseus.skeleton.batch.job.example

import com.teseus.skeleton.batch.domain.ExampleService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class ExampleLogicTasklet(
    private val property: ExampleLogicProperty,
    private val exampleService: ExampleService
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        exampleService.skeleton(property.exampleLogicCode)
        return RepeatStatus.FINISHED
    }
}
