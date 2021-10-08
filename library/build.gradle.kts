plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

repositories {
    mavenCentral()
    google()
    maven(url = "https://jitpack.io")
}

group = "com.github.ryukw7"
version = "0.0.9"

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "0.0.9"
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
    sourceSets.getByName("test") {
        java.srcDir("src/test/kotlin")
    }
}

dependencies {
    implementation(LibDependencies.mainDeps)
    testImplementation(LibDependencies.testDeps)
}

apply(from = "publishing.gradle")

//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = "com.github.ryukw7"
//            artifactId = "pkt"
//            version = "0.0.8"
//        }
//    }
//}

