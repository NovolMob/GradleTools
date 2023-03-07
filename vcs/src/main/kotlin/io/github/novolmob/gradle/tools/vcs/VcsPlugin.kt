package io.github.novolmob.gradle.tools.vcs

import io.github.novolmob.gradle.tools.vcs.storage.ProjectMavenArtifactStorage
import io.github.novolmob.gradle.tools.vcs.storage.ProjectPublicationStorage
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class VcsPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("maven-publish")

        val mavenArtifactStorage = ProjectMavenArtifactStorage(target)
        val publishingStorage = ProjectPublicationStorage(target)

        target.extensions.findByName(io.github.novolmob.gradle.tools.vcs.extension.VcsExtension.NAME) ?:
            target.extensions.create(
                io.github.novolmob.gradle.tools.vcs.extension.VcsExtension.NAME, io.github.novolmob.gradle.tools.vcs.extension.VcsExtensionImpl::class,
                mavenArtifactStorage, publishingStorage
            )
    }

}