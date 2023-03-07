package io.github.novolmob.gradle.tools.vcs.common

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

interface MavenArtifact {
    fun RepositoryHandler.register(): MavenArtifactRepository
}