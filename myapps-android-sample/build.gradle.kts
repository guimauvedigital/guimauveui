plugins {
    kotlin("android")
    kotlin("plugin.compose")
    id("com.android.application")
}

android {
    namespace = "me.nathanfallet.myapps.sample"
    compileSdk = 34
    defaultConfig {
        applicationId = "me.nathanfallet.myapps.sample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.3.2"
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":myapps-android-compose"))
    implementation(project(":myapps-android-preferences"))
    implementation(project(":myapps-android-recyclerview"))

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.compose.ui:ui:1.6.7")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("com.github.JamalMulla:ComposePrefs3:1.0.4")
}
