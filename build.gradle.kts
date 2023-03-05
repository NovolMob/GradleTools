plugins {
    `maven-publish`
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.6.21"
    id("com.gradle.plugin-publish") version "1.1.0"
}

group = "ru.novolmob.gradle.tools"
version = "0.0.1"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        register("VcsTools", MavenPublication::class.java) {
            this.groupId = "ru.novolmob.gradle.tools.vcs"
            this.artifactId = "vcs-tools"
            this.version = project.version.toString()
            from(project.components["java"])
        }
    }

}

pluginBundle {

    vcsUrl = "https://github.com/NovolMob/GradleTools.git"
}

gradlePlugin {
    plugins {
        create("VcsTools") {
            id = "ru.novolmob.gradle.tools.vcs"
            implementationClass = "ru.novolmob.gradle.tools.vcs.VcsPlugin"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    testImplementation(kotlin("test"))
}