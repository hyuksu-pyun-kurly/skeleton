package com.teseus.skeleton.test.api

import io.restassured.config.EncoderConfig
import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter
import java.nio.charset.StandardCharsets

@Tag("restdocs")
@SpringBootTest
@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
abstract class RestDocsTest {
    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext
    private lateinit var restDocumentation: RestDocumentationContextProvider

    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider) {
        this.restDocumentation = restDocumentation
    }

    private fun createMockMvc(): MockMvc {
        return MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .addFilters<DefaultMockMvcBuilder>(CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
            .apply<DefaultMockMvcBuilder>(documentationConfiguration(restDocumentation))
            .build()
    }

    protected fun given(): MockMvcRequestSpecification {
        val mockMvc = createMockMvc()
        return given(mockMvc)
    }

    protected fun given(mockMvc: MockMvc?): MockMvcRequestSpecification {
        val config: RestAssuredMockMvcConfig = RestAssuredMockMvcConfig()
            .encoderConfig(
                EncoderConfig.encoderConfig()
                    .defaultCharsetForContentType(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8.name())
                    .defaultContentCharset(StandardCharsets.UTF_8.name())
            )
        return RestAssuredMockMvc.given()
            .config(config)
            .mockMvc(mockMvc)
    }
}
