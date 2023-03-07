package io.github.novolmob.gradle.tools.vcs.utils

import io.github.novolmob.gradle.tools.vcs.publication.Publication
import io.github.novolmob.gradle.tools.vcs.utils.MavenArtifactUtil.registerMavenArtifact
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.publish.PublishingExtension

object PublishingExtensionUtil {

    fun ExtensionContainer.getPublishingExtension(): PublishingExtension? =
        findByName(PublishingExtension.NAME) as? PublishingExtension

    fun PublishingExtension.registerPublication(publication: Publication<*>) {
        repositories.registerMavenArtifact(publication)
        with(publication) {
            publications.register()
        }
    }

    fun PublishingExtension.registerPublications(publications: List<Publication<*>>) {
        publications.forEach { registerPublication(it) }
    }

}