plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.1.0").apply(false)
    id("com.android.library").version("8.1.0").apply(false)
    kotlin("android").version("1.9.20").apply(false)
    kotlin("multiplatform").version("1.9.20").apply(false)
    kotlin("plugin.serialization").version("1.9.20").apply(false)
    id("convention.publication").apply(false)
    id("org.jetbrains.kotlinx.kover").version("0.7.4").apply(false)
    id("com.google.devtools.ksp").version("1.9.20-1.0.13").apply(false)
    id("org.jetbrains.compose").version("1.5.10").apply(false)
}

allprojects {
    group = "me.nathanfallet.myapps"
    version = "1.3.0"

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
