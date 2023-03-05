package ru.novolmob.gradle.tools.vcs.storage

import org.gradle.api.Project
import ru.novolmob.gradle.tools.vcs.publication.Publication
import ru.novolmob.gradle.tools.vcs.utils.PublishingExtensionUtil.getPublishingExtension
import ru.novolmob.gradle.tools.vcs.utils.PublishingExtensionUtil.registerPublication
import ru.novolmob.gradle.tools.vcs.utils.PublishingExtensionUtil.registerPublications

class ProjectPublicationStorage(
    project: Project
): PublishingStorage<Publication<*>> {
    private val publishingExtension = project.extensions.getPublishingExtension()

    override fun add(value: Publication<*>) {
        publishingExtension?.registerPublication(value) ?: println("Подключите плагин для публикации maven-пакетов!")
    }

    override fun addAll(values: List<Publication<*>>) {
        publishingExtension?.registerPublications(values) ?: println("Подключите плагин для публикации maven-пакетов!")
    }
}