plugins {
    id("com.github.ben-manes.versions") version ver.gradle_versions_plugin
}

group = "org.pkt"
version = "0.0.1"

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        LibDependencies.classpaths.forEach { classpath(it) }

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

listOf(
        "test-report",
        "versions-plugin"
).forEach { apply(from = "common/${it}.gradle") }

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
