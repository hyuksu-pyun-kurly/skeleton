package com.teseus.skeleton.batch.configuration

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
@EnableBatchProcessing
class BatchConfiguration : DefaultBatchConfigurer() {
    override fun setDataSource(dataSource: DataSource) {
        // ignores DataSource
    }

    @Primary
    @Bean
    fun jpaTransactionManager(transactionManagerCustomizers: ObjectProvider<TransactionManagerCustomizers>): PlatformTransactionManager? {
        val transactionManager = JpaTransactionManager()
        transactionManagerCustomizers.ifAvailable { customizers: TransactionManagerCustomizers ->
            customizers.customize(
                transactionManager
            )
        }
        return transactionManager
    }
}
