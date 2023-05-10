plugins{
    `kotlin-dsl`
    id(Dependencies.Plugin.androidApplication) version Dependencies.Version.agp apply false
    id(Dependencies.Plugin.androidLibrary) version Dependencies.Version.agp apply false
    id(Dependencies.Plugin.kotlinAndroid) version Dependencies.Version.kotlin apply false
    id(Dependencies.Plugin.kotlinJvm) version Dependencies.Version.kotlin apply false
    id ("androidx.navigation.safeargs") version "2.5.2" apply false
}

