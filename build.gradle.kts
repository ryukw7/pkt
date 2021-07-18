plugins {
    `maven-publish`
    id("com.github.ben-manes.versions") version ver.gradle_versions_plugin
}

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
        maven(url = "https://jitpack.io")
    }
}

listOf(
    "test-report",
    "versions-plugin"
).forEach { apply(from = "common/${it}.gradle") }

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.pkt"
            artifactId = "final"
            version = "0.0.2"
        }
    }
}
