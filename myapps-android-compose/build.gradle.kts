plugins {
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("plugin.compose")
    id("com.android.library")
    id("convention.publication")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
}

android {
    namespace = "me.nathanfallet.myapps.compose"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
    publishing {
        multipleVariants {
            allVariants()
            withJavadocJar()
        }
    }
}

dependencies {
    api(project(":myapps-android"))

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.compose.ui:ui:1.6.7")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("com.github.JamalMulla:ComposePrefs3:1.0.4")
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("android") {
            from(components["default"])
            pom {
                name.set("myapps-android-compose")
                description.set("Compose views to list my Android apps.")
            }
        }
    }
}
