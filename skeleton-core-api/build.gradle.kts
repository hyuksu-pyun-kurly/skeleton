tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":common:enum"))
    implementation(project(":common:util"))
    implementation(project(":modules:kms"))
    implementation(project(":modules:monitoring"))
    implementation(project(":modules:logging"))
    implementation(project(":modules:cloud-config"))
    implementation(project(":storage:db-core"))
    implementation(project(":clients:client-example"))

    testImplementation(project(":tests:api-docs"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}
