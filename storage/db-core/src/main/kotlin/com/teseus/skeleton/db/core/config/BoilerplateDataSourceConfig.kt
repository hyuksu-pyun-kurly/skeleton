package com.teseus.skeleton.db.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class BoilerplateDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "teseus.datasource.skeleton")
    fun skeletonHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun skeletonDataSource(@Qualifier("skeletonHikariConfig") config: HikariConfig): HikariDataSource {
        return HikariDataSource(config)
    }
}
