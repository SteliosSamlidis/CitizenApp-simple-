plugins {
    id("java")
}

group = "org.citizen"
version = "1.0-SNAPSHOT"

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // JPA and Hibernate dependencies
    implementation("org.hibernate:hibernate-core:5.5.7.Final")
    implementation("org.postgresql:postgresql:42.2.20")
    implementation("javax.persistence:javax.persistence-api:2.2")

    // Test dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}