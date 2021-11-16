val commonVersion: String by project

dependencies {
    implementation(project(":common:enum"))
    implementation(project(":common:util"))
    compileOnly("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-httpclient")
}
