pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // Plugins
            version("kotlin", "2.0.0")
            version("agp", "8.2.1")
            plugin("multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
            plugin("android-kotlin", "org.jetbrains.kotlin.android").versionRef("kotlin")
            plugin("serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
            plugin("compose", "org.jetbrains.kotlin.plugin.compose").versionRef("kotlin")
            plugin("composeCompiler", "org.jetbrains.compose").version("1.6.11")
            plugin("android-library", "com.android.library").versionRef("agp")
            plugin("android-application", "com.android.application").versionRef("agp")
            plugin("kover", "org.jetbrains.kotlinx.kover").version("0.8.0")
            plugin("ksp", "com.google.devtools.ksp").version("2.0.0-1.0.21")
            plugin("maven", "com.vanniktech.maven.publish").version("0.28.0")

            // Kaccelero
            version("kaccelero", "0.2.0")
            library("kaccelero-core", "dev.kaccelero", "core").versionRef("kaccelero")

            // Tests
            library("tests-mockk", "io.mockk:mockk:1.13.11")
        }
    }
}

rootProject.name = "guimauveui"
include(":guimauveui")
include(":guimauveui-sample")
