plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.sports_assistant_system"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sports_assistant_system"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    //调取天气api需要
    implementation("com.squareup.retrofit2:retrofit:2.1.0")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.1.0")
    implementation("com.squareup.picasso:picasso:2.5.2")

    //easypermissions
    implementation("pub.devrel:easypermissions:3.0.0")

    //高德
    implementation(files("libs\\AMap2DMap_6.0.0_AMapSearch_9.7.2_AMapLocation_6.4.5_20240508.jar"))

    //bmob后端云
    implementation ("io.github.bmob:android-sdk:4.0.4")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.9")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("com.squareup.okhttp3:okhttp:4.8.1")
    implementation ("com.squareup.okio:okio:2.2.2")
    implementation ("com.google.code.gson:gson:2.8.5")

    //viewpager2
    implementation ("androidx.viewpager2:viewpager2:1.0.0-alpha02")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}