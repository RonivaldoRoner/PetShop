plugins {
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

dependencies{
    implementation(Dependencies.Android.coroutinesCore)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>{
    kotlinOptions{
        apiVersion = Dependencies.Config.kotlinTarget
        languageVersion = Dependencies.Config.kotlinTarget
        jvmTarget = Dependencies.Config.javaJvmTarget
    }
}