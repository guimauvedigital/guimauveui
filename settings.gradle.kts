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

rootProject.name = "myapps"
includeBuild("convention-plugins")
include(":myapps")
include(":myapps-android")
include(":myapps-android-compose")
include(":myapps-android-preferences")
include(":myapps-android-recyclerview")
include(":app")
