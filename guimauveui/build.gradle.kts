plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kover)
    alias(libs.plugins.ksp)
    alias(libs.plugins.maven)
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
    pom {
        name.set("guimauveui")
        description.set("The core of our reusable UI components.")
        url.set("https://github.com/guimauvesoftware/guimauveui")

        licenses {
            license {
                name.set("GPL-3.0")
                url.set("https://opensource.org/licenses/GPL-3.0")
            }
        }
        developers {
            developer {
                id.set("NathanFallet")
                name.set("Nathan Fallet")
                email.set("contact@nathanfallet.me")
                url.set("https://www.nathanfallet.me")
            }
        }
        scm {
            url.set("https://github.com/guimauvesoftware/guimauveui.git")
        }
    }
}

kotlin {
    // Tiers are in accordance with <https://kotlinlang.org/docs/native-target-support.html>
    // Tier 1
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()

    // Tier 2
    //linuxX64()
    //linuxArm64()
    //watchosSimulatorArm64()
    //watchosX64()
    //watchosArm32()
    //watchosArm64()
    //tvosSimulatorArm64()
    //tvosX64()
    //tvosArm64()
    iosArm64()

    // Tier 3
    //mingwX64()
    //watchosDeviceArm64()

    // jvm & js
    jvmToolchain(21)
    androidTarget()
    jvm {
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        binaries.library()
        nodejs()
        browser()
        //generateTypeScriptDefinitions() // Not supported for now because of collections etc...
    }

    applyDefaultHierarchyTemplate()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kaccelero.core)
                api(compose.runtime)
                api(compose.ui)
                api(compose.material3)
                api(compose.components.resources)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.tests.mockk)
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.core:core-ktx:1.13.1")
                api("com.github.JamalMulla:ComposePrefs3:1.0.4")
            }
        }
    }
}

compose {
    resources {
        publicResClass = true
        packageOfResClass = "software.guimauve"
        generateResClass = always
    }
}

android {
    namespace = "software.guimauve.android"
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
