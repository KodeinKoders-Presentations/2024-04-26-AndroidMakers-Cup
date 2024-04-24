plugins {
    kotlin("multiplatform") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.2"
    id("net.kodein.cup") version "1.0.0-Beta-01"
    id("net.kodein.gradle.resources.resource-files") version "1.0.0"
}

cup {
    targetDesktop()
    targetWeb()
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation("net.kodein.themes:cup:2.0.0")
            implementation("io.github.alexzhirkevich:qrose:1.0.1")
        }
        resources.srcDirs(resourceFiles.outputDir)
    }
}

tasks.withType<ProcessResources> {
    dependsOn(tasks.importResourceFiles)
}

dependencies {
    resourceFiles("net.kodein.themes:base-resources-font:2.0.0")
}