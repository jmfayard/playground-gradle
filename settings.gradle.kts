// settings.gradle.kts
plugins {
    id("com.gradle.develocity") version "3.18.1"
}

// https://docs.gradle.com/develocity/gradle-plugin/current/
develocity {
    buildScan {
        publishing.onlyIf { true }
        termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
        termsOfUseAgree.set("yes")
    }
}


rootProject.name = "gs-multi-module"

include("library")
include("application")

