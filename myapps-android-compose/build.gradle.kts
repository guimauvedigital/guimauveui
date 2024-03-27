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
                api("androidx.compose.ui:ui:1.6.4")
                api("androidx.compose.material:material:1.6.4")
                api("androidx.datastore:datastore-preferences:1.0.0")
                api("com.github.JamalMulla:ComposePrefs:1.0.6")
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
}
