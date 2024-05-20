plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.pdharam.tendable"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pdharam.tendable"
        minSdk = 24
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

    buildFeatures {
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.convertergson)
    //Okhttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logginginterceptor)
    //coroutine
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    //room
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    implementation(libs.room.runtime)
    //room
    implementation(libs.lifecycle.viewmodelktx)
    implementation(libs.lifecycle.livedataktx)
    implementation(libs.lifecycle.runtimektx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}