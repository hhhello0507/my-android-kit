plugins {
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.2.2" apply false
    id("com.android.application") version "8.2.2" apply false
}

buildscript {
    dependencies {
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}