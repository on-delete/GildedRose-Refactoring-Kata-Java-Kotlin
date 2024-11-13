plugins {
    java
    application
}

group = "com.gildedrose"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

java {
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.register<JavaExec>("texttest") {
    mainClass = "com.gildedrose.TexttestFixture"
    classpath = sourceSets["test"].runtimeClasspath
    args = listOf("30")
}

application {
    mainClass = "com.gildedrose.TexttestFixture"
}
