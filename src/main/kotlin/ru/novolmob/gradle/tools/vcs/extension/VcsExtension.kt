package ru.novolmob.gradle.tools.vcs.extension

import org.gradle.api.Action
import ru.novolmob.gradle.tools.vcs.publication.VcsPublishing
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact
import ru.novolmob.gradle.tools.vcs.storage.MavenArtifactStorage
import ru.novolmob.gradle.tools.vcs.publication.Publication
import ru.novolmob.gradle.tools.vcs.storage.PublishingStorage

interface VcsExtension {

    val mavenArtifactStorage: MavenArtifactStorage<MavenArtifact>
    val publishingStorage: PublishingStorage<Publication<*>>

    fun publish(action: Action<VcsPublishing>)

    companion object {
        const val NAME: String = "vcs"
    }

}