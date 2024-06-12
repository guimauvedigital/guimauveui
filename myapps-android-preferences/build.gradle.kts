plugins {
    kotlin("android")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("convention.publication")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
}

android {
    namespace = "me.nathanfallet.myapps.preferences"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.1")
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("android") {
            from(components["default"])
            pom {
                name.set("myapps-android-preferences")
                description.set("Preferences views to list my Android apps.")
            }
        }
    }
}
