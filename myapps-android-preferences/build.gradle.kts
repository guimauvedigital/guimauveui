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
            name.set("myapps-android-preferences")
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
                implementation("androidx.appcompat:appcompat:1.6.1")
                implementation("androidx.cardview:cardview:1.0.0")
                implementation("androidx.preference:preference-ktx:1.2.1")
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
    namespace = "me.nathanfallet.myapps.preferences"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}
