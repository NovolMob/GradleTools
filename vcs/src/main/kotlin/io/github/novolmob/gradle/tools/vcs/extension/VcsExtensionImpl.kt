package io.github.novolmob.gradle.tools.vcs.extension

import io.github.novolmob.gradle.tools.vcs.common.MavenArtifact
import io.github.novolmob.gradle.tools.vcs.publication.Publication
import io.github.novolmob.gradle.tools.vcs.publication.VcsPublishing
import io.github.novolmob.gradle.tools.vcs.publication.VcsPublishingImpl
import io.github.novolmob.gradle.tools.vcs.storage.MavenArtifactStorage
import io.github.novolmob.gradle.tools.vcs.storage.PublishingStorage
import org.gradle.api.Action

open class VcsExtensionImpl(
    override val mavenArtifactStorage: MavenArtifactStorage<MavenArtifact>,
    override val publishingStorage: PublishingStorage<Publication<*>>
): VcsExtension {
    override fun publish(action: Action<VcsPublishing>) {
        val publishing = VcsPublishingImpl(publishingStorage)
        action.execute(publishing)
    }

}