plugins {
    kotlin("android")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("convention.publication")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
}

android {
    namespace = "me.nathanfallet.myapps.android"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    publishing {
        multipleVariants {
            allVariants()
            withJavadocJar()
        }
    }
}

dependencies {
    api(project(":myapps"))
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("android") {
            from(components["default"])
            pom {
                name.set("myapps-android")
                description.set("A list of my Android apps.")
            }
        }
    }
}
