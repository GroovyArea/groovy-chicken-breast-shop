import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version Dependency.springBootVersion
    id("io.spring.dependency-management") version "1.1.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"

    kotlin("jvm") version Dependency.kotlinVersion
    kotlin("plugin.spring") version Dependency.kotlinVersion
    kotlin("plugin.jpa") version Dependency.kotlinVersion
    kotlin("plugin.allopen") version Dependency.kotlinVersion
    kotlin("kapt") version Dependency.kotlinVersion
}

group = "com.groovyarea.product"
version = Constant.VERSION

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

apply(plugin = "kotlin-kapt")

dependencies {

    // spring
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // spring reactive mongo
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

    // spring reactive redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")

    // detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.5.4.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.4.Final")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")

    // kotest
    testImplementation("io.kotest:kotest-runner-junit5:${Dependency.kotestVersion}")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:${Dependency.kotestSprintExtensions}")
    testImplementation("io.mockk:mockk:${Dependency.mockkVersion}")

    kaptTest("org.mapstruct:mapstruct-processor:1.5.4.Final")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = Dependency.targetJvmVersion
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

allOpen {
    annotation("org.springframework.data.mongodb.core.mapping.Document")
}

noArg {
    annotation("org.springframework.data.mongodb.core.mapping.Document")
}

detekt {
    autoCorrect = true
}