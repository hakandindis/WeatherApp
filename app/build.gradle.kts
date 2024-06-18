plugins {
    kotlin("kapt")
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.kts)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.firebaseCrashlytics)
    alias(libs.plugins.compose.compiler)
}

android {
    buildToolsVersion = "34.0.0"
    namespace = "com.hakandindis.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hakandindis.weatherapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:ui-components"))
    implementation(project(":feature:main"))
    implementation(project(":feature:widget"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.hilt)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.coroutines)
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)
    implementation(libs.navigation.compose)
    implementation(libs.viewmodel)
    implementation(libs.livedata)
    implementation(libs.lifecycle)
    implementation(libs.savedsatateViewmodel)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.viewmodel)
    implementation(libs.compose.runtime)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.foundation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.animation)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.material3.window)
    implementation(libs.compose.ui)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.lottie)
    implementation(libs.coil)
    implementation(libs.androidx.profileinstaller)

    implementation(libs.timber)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    ksp(libs.hiltCompiler)
    kapt(libs.lifecycleCompiler)

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}