object Dependencies {

    object Config {
        const val applicationId = "com.ronivaldoroner.petshop"
        const val compileSdk = 33
        const val minSdk = 22
        const val targetSdk = 33
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Version {
        const val agp = "8.0.0"
        const val kotlin = "1.8.10"
        const val coreKtx = "1.10.0"
        const val lifecycleKtx = "2.6.1"
        const val koin = "3.1.5"
        const val appCompat = "1.6.1"
        const val navigation = "2.5.3"

        //Compose
        const val bomCompose = "2023.04.01"
        const val activityCompose = "1.7.1"

        //Network
        const val retrofit = "2.9.0"
        const val okhttp = "4.10.0"

        //Test
        const val jUnit = "4.13.2"
        const val testExtJunit = "1.1.5"
        const val espressoCore = "3.5.1"
    }

    object Plugin {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinJvm = "org.jetbrains.kotlin.jvm"
        const val navigationSafeArgs = "androidx.navigation.safeargs"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleKtx}"
        const val koin = "io.insert-koin:koin-android:${Version.koin}"
        const val koinCore = "io.insert-koin:koin-core:${Version.koin}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

        //Compose
        const val bomCompose = "androidx.compose:compose-bom:${Version.bomCompose}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
        const val uiCompose = "androidx.compose.ui:ui"
        const val uiGraphicsCompose = "androidx.compose.ui:ui-graphics"
        const val uiPreviewCompose = "androidx.compose.ui:ui-tooling-preview"
        const val materialCompose = "androidx.compose.material3:material3"

        //Network
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }

    object Test {
        const val junit = "junit:junit:${Version.jUnit}"
        const val testExtJunit = "androidx.test.ext:junit:${Version.testExtJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
        const val bomCompose = "androidx.compose:compose-bom:${Version.bomCompose}"
        const val junitCompose = "androidx.compose.ui:ui-test-junit4"
        const val uiToolingCompose = "androidx.compose.ui:ui-tooling"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
    }
}