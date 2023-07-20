plugins {
    alias(libs.plugins.kotlin.jvm)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(project(":network"))
    implementation(project(":domain"))
    implementation(project(":common:jvm"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.moshi)
    ksp(libs.moshi.codegen)
    implementation(libs.retrofit.core)
    implementation(libs.hilt.core)
    kapt(libs.hilt.core.compiler)
}