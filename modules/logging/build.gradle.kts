val commonVersion: String by project
val sentryVersion: String by project
dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("io.sentry:sentry-logback:${sentryVersion}")
}
