package ru.novolmob.gradle.tools.vcs.publication

import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.publish.PublicationContainer
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact

interface Publication<U>: MavenArtifact {

    fun PublicationContainer.register(): NamedDomainObjectProvider<U>

}