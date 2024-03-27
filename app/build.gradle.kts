plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "me.nathanfallet.myapps.sample"
    compileSdk = 34
    defaultConfig {
        applicationId = "me.nathanfallet.myapps.sample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.3.0"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {
    implementation(project(":myapps-android-compose"))
    implementation(project(":myapps-android-preferences"))
    implementation(project(":myapps-android-recyclerview"))
}
