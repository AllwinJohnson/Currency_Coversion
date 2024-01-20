plugins {
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("com.google.devtools.ksp")
}

android {
    namespace = "com.allwin.currencycoversion"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.allwin.currencycoversion"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug{
            buildConfigField("String", "BASE_URL", "\"https://openexchangerates.org/api/\"")
            buildConfigField("String", "EXCHANGE_API_KEY", "\"af1b0370e4c7479da50e55b6af0b78fc\"")
        }

        release {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "\"https://openexchangerates.org/api/\"")
            buildConfigField("String", "EXCHANGE_API_KEY", "\"af1b0370e4c7479da50e55b6af0b78fc\"")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

//    coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")


//    retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

//    okhttp
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8")

//    timber
    implementation("com.jakewharton.timber:timber:5.0.1")

//    room
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

}

kapt {
    correctErrorTypes = true
}