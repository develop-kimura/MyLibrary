plugins {
    `maven-publish`
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

group = "com.github.develop-kimura"

android {
    namespace = "com.nk.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
    }

    lint {
        targetSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.develop-kimura"
            artifactId = "MyLibrary"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
