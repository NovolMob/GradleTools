package ru.novolmob.gradle.tools.vcs

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import ru.novolmob.gradle.tools.vcs.extension.VcsExtension
import ru.novolmob.gradle.tools.vcs.extension.VcsExtensionImpl
import ru.novolmob.gradle.tools.vcs.storage.ProjectMavenArtifactStorage
import ru.novolmob.gradle.tools.vcs.storage.ProjectPublicationStorage

class VcsPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("maven-publish")

        val mavenArtifactStorage = ProjectMavenArtifactStorage(target)
        val publishingStorage = ProjectPublicationStorage(target)

        target.extensions.findByName(VcsExtension.NAME) ?:
            target.extensions.create(
                VcsExtension.NAME, VcsExtensionImpl::class,
                mavenArtifactStorage, publishingStorage
            )
    }

}