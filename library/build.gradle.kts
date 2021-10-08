plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "0.0.7"
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.ryukw7"
            artifactId = "pkt"
            version = "0.0.7"
        }
    }
}

