package ru.novolmob.gradle.tools.vcs.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact

object MavenArtifactUtil {

    fun RepositoryHandler.registerMavenArtifact(mavenArtifact: MavenArtifact) {
        with(mavenArtifact) { register(); }
    }

    fun Project.registerMavenArtifact(mavenArtifact: MavenArtifact) {
        repositories.registerMavenArtifact(mavenArtifact)
    }

    fun Project.registerMavenArtifacts(mavenArtifacts: List<MavenArtifact>) {
        mavenArtifacts.forEach { registerMavenArtifact(it) }
    }

}