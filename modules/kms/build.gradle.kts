val commonVersion: String by project
dependencies {
    /**
     * * 참고
     * AWS Core AMAZON WEB SERVICES
     * AWS native services from Spring Cloud for AWS.
     * Requires Spring Boot >= 2.0.0.RELEASE and < 2.4.0.M1.
     */
    runtimeOnly("com.amazonaws:aws-java-sdk-kms:1.11.944")
}
