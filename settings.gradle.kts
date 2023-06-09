pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PetShop"
include(":app")
include(":domain")
include(":remote")

project(":app").projectDir = File(rootDir, "app")
project(":domain").projectDir = File(rootDir, "domain")
project(":remote").projectDir = File(rootDir, "providers/remote")


