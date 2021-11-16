package com.teseus.skeleton.batch.job

import com.teseus.skeleton.batch.job.example.ExampleLogicTasklet
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JobManager(
    private val jobBuilder: JobBuilderFactory,
    private val stepBuilder: StepBuilderFactory
) {
    companion object {
        private const val BOILERPLATE_LOGIC_JOB = "BoilerplateLogicJob"
    }

    @Bean(name = [BOILERPLATE_LOGIC_JOB])
    fun agreementResultCheck(tasklet: ExampleLogicTasklet): Job {
        return jobBuilder[BOILERPLATE_LOGIC_JOB]
            .start(
                stepBuilder[tasklet.javaClass.name]
                    .tasklet(tasklet)
                    .build()
            ).build()
    }

    @Bean(name = ["stepNextJob"])
    fun stepNextJob(): Job {
        return jobBuilder.get("stepNextJob")
            .start(step1())
            .next(step2())
            .next(step3())
            .next(step4WithParam(null))
            .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilder.get("step1")
            .tasklet(Tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                println(">>>>> This is Step1")
                RepeatStatus.FINISHED
            })
            .build()
    }

    @Bean
    fun step2(): Step {
        return stepBuilder.get("step2")
            .tasklet(Tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                println(">>>>> This is Step2")
                RepeatStatus.FINISHED
            })
            .build()
    }

    @Bean
    fun step3(): Step {
        return stepBuilder.get("step3")
            .tasklet(Tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                println(">>>>> This is Step3")
                RepeatStatus.FINISHED
            })
            .build()
    }

    @Bean
    @JobScope
    fun step4WithParam(@Value("#{jobParameters[date]}") date: String?): Step {
        return stepBuilder.get("step4WithParam")
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                println(">>>>> This is Step4 with jobParameters. date : $date")
                RepeatStatus.FINISHED
            }
            .build()
    }
}
