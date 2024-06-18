plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.com.google.devtools.kts)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.hakandindis.main"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

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
    buildFeatures {
        buildConfig = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.coroutines)
    implementation(libs.coil.compose)

    implementation(libs.lifecycle)
    implementation(libs.viewmodel)
    implementation(libs.viewmodel.compose)
    implementation(libs.lifecycle.compose)


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

    implementation(libs.navigation.compose)

    implementation(libs.hilt)
    implementation(libs.hilt.navigation.compose)

    ksp(libs.hiltCompiler)



    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}