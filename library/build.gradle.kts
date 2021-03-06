plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

group = ver.groupId
version = ver.lib

android {
    compileSdk = 30

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets.getByName("main") {
        java.srcDir("src/main/kotlin")
    }
    sourceSets.getByName("test") {
        java.srcDir("src/test/kotlin")
    }
}

dependencies {
    set(deps.pkt)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.
                from(components["release"])
                groupId = ver.groupId
                artifactId = ver.artifactId
                version = ver.lib
            }
        }
    }
}
