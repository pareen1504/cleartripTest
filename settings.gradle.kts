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

rootProject.name = "cleartripTest"
include(":app")
include(":data")
include(":domain")
include(":common:jvm")
include(":common:palette")
include(":feature:testFeature")
include(":network")
