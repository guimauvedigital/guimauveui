plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("convention.publication")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("myapps-android-compose")
            description.set("A list of my iOS & Android apps, with associated views (UIKit, SwiftUI, Preferences, ...), to embed in all of them.")
        }
    }
}

kotlin {
    androidTarget()

    applyDefaultHierarchyTemplate()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":myapps-android"))

                implementation("androidx.core:core-ktx:1.12.0")
                implementation("androidx.compose.ui:ui:1.6.4")
                implementation("androidx.compose.material3:material3:1.2.1")
                implementation("com.github.JamalMulla:ComposePrefs3:1.0.4")
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("io.mockk:mockk:1.13.10")
            }
        }
    }
}

android {
    namespace = "me.nathanfallet.myapps.compose"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
}
