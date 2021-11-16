rootProject.name = "skeleton"

include(
    "skeleton-core-api",
    "skeleton-batch",
    "storage:db-core",
    "tests:api-docs",
    "common:enum",
    "common:util",
    "modules:kms",
    "modules:logging",
    "modules:monitoring",
    "modules:cloud-config",
    "clients:client-example"
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val asciidoctorConvertVersion: String by settings
    val kotlinterVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.asciidoctor.jvm.convert" -> useVersion(asciidoctorConvertVersion)
                "org.jmailen.kotlinter" -> useVersion(kotlinterVersion)
            }
        }
    }
}