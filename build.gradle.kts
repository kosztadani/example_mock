import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    id("java")
}

group = "dev.kosztadani.examples.mock"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.7.0"
    testImplementation(group="org.junit.jupiter", name="junit-jupiter-api", version=junitVersion)
    testRuntimeOnly(group="org.junit.jupiter", name="junit-jupiter-engine", version=junitVersion)

    val mockitoVersion = "3.9.0"
    testImplementation(group="org.mockito", name="mockito-core", version=mockitoVersion)
    testImplementation(group="org.mockito", name="mockito-junit-jupiter", version=mockitoVersion)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(PASSED, SKIPPED, FAILED)
    }
}
