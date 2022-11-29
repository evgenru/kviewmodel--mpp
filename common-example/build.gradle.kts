plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

android {
    namespace = "com.adeo.kviewmodel.example.common"
}

kotlin {
    cocoapods {
        summary = "KViewModel iOS Example"
        homepage = "https://github.com/adeo/kviewmodel--mpp"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            baseName = "KViewModelShared"
            export(project(":kviewmodel"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.kviewmodel)
                implementation(libs.coroutines.core)
            }
        }
    }
}