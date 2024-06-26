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
    listOf(
        macosX64(),
        macosArm64(),
        iosSimulatorArm64(),
        iosX64(),
        iosArm64()
    ).forEach {
        it.compilations.getByName("main") {
            cinterops.create("GuimauveUI") {
                includeDirs("$projectDir/../Sources/GuimauveUIObjc/include")
            }
        }
    }

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

    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }
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
                implementation(compose.preview)
                api("androidx.core:core-ktx:1.13.1")
                api("com.github.JamalMulla:ComposePrefs3:1.0.4")
                api("com.airbnb.android:lottie-compose:6.3.0")
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
