plugins {
    id("org.jetbrains.kotlin.kapt")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(project(":common:jvm"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
}