plugins {
    `maven-publish`
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm")
    id("com.gradle.plugin-publish")
}

group = "${rootProject.group}.$name"
version = rootProject.version

repositories {
    mavenCentral()
}

publishing {
    repositories {
        mavenLocal()
    }
    publications {
        register("VcsTool", MavenPublication::class.java) {
            this.groupId = rootProject.group.toString()
            this.artifactId = project.name
            this.version = version.toString()
            from(components["java"])
        }
    }

}

pluginBundle {
    website = "https://github.com/NovolMob/GradleTools"
    vcsUrl = "https://github.com/NovolMob/GradleTools.git"
    tags = listOf("vcs", "publishing", "gitlab", "repository package")
}

gradlePlugin {
    plugins {
        create("VcsTool") {
            id = project.group.toString()
            implementationClass = "${project.group}.VcsPlugin"
            displayName = "Vcs Tool"
            description = "A tool for working with packages published to Git repositories (only Gitlab so far)."
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    testImplementation(kotlin("test"))
}