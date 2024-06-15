plugins {
    //trick: for the same plugin versions in all sub-modules
    kotlin("android").version("2.0.0").apply(false)
    kotlin("multiplatform").version("2.0.0").apply(false)
    kotlin("plugin.serialization").version("2.0.0").apply(false)
    kotlin("plugin.compose").version("2.0.0").apply(false)
    id("com.android.application").version("8.2.1").apply(false)
    id("com.android.library").version("8.2.1").apply(false)
    id("convention.publication").apply(false)
    id("org.jetbrains.kotlinx.kover").version("0.8.0").apply(false)
    id("com.google.devtools.ksp").version("2.0.0-1.0.21").apply(false)
}

allprojects {
    group = "me.nathanfallet.myapps"
    version = "1.3.3"

    repositories {
        mavenCentral()
        google()
        maven("https://jitpack.io")
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}
