plugins {
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
}

allprojects {
    group = "software.guimauve"
    version = "2.0.2"

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
