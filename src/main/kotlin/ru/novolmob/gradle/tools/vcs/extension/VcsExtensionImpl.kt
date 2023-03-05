package ru.novolmob.gradle.tools.vcs.extension

import org.gradle.api.Action
import ru.novolmob.gradle.tools.vcs.publication.VcsPublishing
import ru.novolmob.gradle.tools.vcs.publication.VcsPublishingImpl
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact
import ru.novolmob.gradle.tools.vcs.storage.MavenArtifactStorage
import ru.novolmob.gradle.tools.vcs.publication.Publication
import ru.novolmob.gradle.tools.vcs.storage.PublishingStorage

open class VcsExtensionImpl(
    override val mavenArtifactStorage: MavenArtifactStorage<MavenArtifact>,
    override val publishingStorage: PublishingStorage<Publication<*>>
): VcsExtension {
    override fun publish(action: Action<VcsPublishing>) {
        val publishing = VcsPublishingImpl(publishingStorage)
        action.execute(publishing)
    }

}