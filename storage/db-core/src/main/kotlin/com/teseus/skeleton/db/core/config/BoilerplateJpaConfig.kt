package com.teseus.skeleton.db.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.teseus.skeleton.db.core"])
@EnableJpaRepositories(basePackages = ["com.teseus.skeleton.db.core"])
internal class BoilerplateJpaConfig
