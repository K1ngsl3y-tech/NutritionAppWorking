plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id ("kotlin-kapt")
// ✅ Required for Kotlin 2.0+
}



android {
    namespace = "com.kingsley.fitnessapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.kingsley.fitnessapp"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11" // ✅ Use a version compatible with Kotlin 2.0
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.material3:material3:1.1.0") // Updated
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation(libs.androidx.runtime.livedata)
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation ("androidx.compose.material:material-icons-extended:<latest-version>")

    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")


    // Firebase, if needed
    // implementation("com.google.firebase:firebase-auth-ktx")
    // implementation("com.google.firebase:firebase-firestore-ktx")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0")
}
