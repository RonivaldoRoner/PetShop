plugins {
    id("com.android.library")
}

android {
    namespace = "com.ronivaldoroner.petshop.remote"
    compileSdkVersion(33)

    defaultConfig {
        minSdkVersion(22)
        targetSdkVersion(33)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(project(":domain"))

    implementation(Dependencies.Android.okhttp)
    implementation(Dependencies.Android.okhttpLogging)
    implementation(Dependencies.Android.retrofit)
    implementation(Dependencies.Android.retrofitGsonConverter)


    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.testExtJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}