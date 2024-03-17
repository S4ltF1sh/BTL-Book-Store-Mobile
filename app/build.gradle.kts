import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.jetbrainsKotlinKapt)
}

val apikeyPropertiesFile = rootProject.file("apikey.properties")
val apikeyProperties = Properties()
apikeyProperties.load(apikeyPropertiesFile.inputStream())

android {
    namespace = "com.s4ltf1sh.bookstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.s4ltf1sh.bookstore"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
    }

    flavorDimensions += "default"
    productFlavors {
        create("dev") {
            dimension = "default"
            applicationIdSuffix = ".dev"
            buildConfigField("String", "BASE_URL_JSON_PLACE_HOLDER", apikeyProperties["BASE_URL_JSON_PLACE_HOLDER_DEV"].toString())
        }

        create("prod") {
            dimension = "default"
            applicationIdSuffix = ".prod"
            buildConfigField("String", "BASE_URL_JSON_PLACE_HOLDER", apikeyProperties["BASE_URL_JSON_PLACE_HOLDER_PROD"].toString())
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Coroutines
    implementation(libs.kotlin.coroutines)

    // Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)

    // Moshi
    implementation(libs.moshi.kotlin)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // glide
    implementation(libs.glide)
}
