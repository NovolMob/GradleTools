package io.github.novolmob.gradle.tools.vcs.extension

import io.github.novolmob.gradle.tools.vcs.common.MavenArtifact
import io.github.novolmob.gradle.tools.vcs.publication.Publication
import io.github.novolmob.gradle.tools.vcs.publication.VcsPublishing
import io.github.novolmob.gradle.tools.vcs.storage.MavenArtifactStorage
import io.github.novolmob.gradle.tools.vcs.storage.PublishingStorage
import org.gradle.api.Action

interface VcsExtension {

    val mavenArtifactStorage: MavenArtifactStorage<MavenArtifact>
    val publishingStorage: PublishingStorage<Publication<*>>

    fun publish(action: Action<VcsPublishing>)

    companion object {
        const val NAME: String = "vcs"
    }

}