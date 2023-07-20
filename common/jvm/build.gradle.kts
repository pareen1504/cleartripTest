plugins {
    alias(libs.plugins.kotlin.jvm)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}