plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.ronivaldoroner.petshop"
    compileSdkVersion(Dependencies.Config.compileSdk)

    defaultConfig {
        applicationId = Dependencies.Config.applicationId
        minSdkVersion(Dependencies.Config.minSdk)
        targetSdkVersion(Dependencies.Config.targetSdk)
        versionCode = Dependencies.Config.versionCode
        versionName = Dependencies.Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":remote"))

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.lifecycleKtx)
    implementation(Dependencies.Android.appCompat)

    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationKtx)

    //Compose
    implementation(Dependencies.Android.activityCompose)
    implementation(platform(Dependencies.Android.bomCompose))
    implementation(Dependencies.Android.uiCompose)
    implementation(Dependencies.Android.uiGraphicsCompose)
    implementation(Dependencies.Android.uiPreviewCompose)
    implementation(Dependencies.Android.materialCompose)

    //koin
    implementation(Dependencies.Android.koin)
    implementation(Dependencies.Android.koinCore)


    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.testExtJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
    androidTestImplementation(platform(Dependencies.Test.bomCompose))
    androidTestImplementation(Dependencies.Test.junitCompose)
    debugImplementation(Dependencies.Test.uiToolingCompose)
    debugImplementation(Dependencies.Test.uiTestManifest)
}