package ru.novolmob.gradle.tools.vcs.storage

import org.gradle.api.Project
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact
import ru.novolmob.gradle.tools.vcs.utils.MavenArtifactUtil.registerMavenArtifact
import ru.novolmob.gradle.tools.vcs.utils.MavenArtifactUtil.registerMavenArtifacts

class ProjectMavenArtifactStorage(
    private val project: Project
): MavenArtifactStorage<MavenArtifact> {
    override fun add(value: MavenArtifact) {
        project.registerMavenArtifact(value)
    }

    override fun addAll(values: List<MavenArtifact>) {
        project.registerMavenArtifacts(values)
    }

}