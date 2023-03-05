package ru.novolmob.gradle.tools.vcs.gitlab

import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.publish.PublicationContainer
import org.gradle.api.publish.maven.MavenPublication
import ru.novolmob.gradle.tools.vcs.publication.Publication
import ru.novolmob.gradle.tools.vcs.utils.GitlabUtil
import ru.novolmob.gradle.tools.vcs.utils.GradleUtil.registerGitlabMavenArtifact
import ru.novolmob.gradle.tools.vcs.utils.GradleUtil.registerGitlabPublication

open class GitlabPublication(
    val uri: String,
    val group: String,
    val artifact: String,
    val version: String,
    val token: GitlabToken
): Publication<MavenPublication> {
    override fun PublicationContainer.register(): NamedDomainObjectProvider<MavenPublication> =
        registerGitlabPublication(group, artifact, version)

    override fun RepositoryHandler.register(): MavenArtifactRepository =
        registerGitlabMavenArtifact(uri, token)

    class Project(
        gitlabUrl: String,
        name: String,
        group: String,
        artifact: String,
        version: String,
        token: GitlabToken
    ): GitlabPublication(
        uri = GitlabUtil.getProjectId(gitlabUrl, name, token).let {
            "$gitlabUrl/api/v4/projects/$it/packages/maven"
        },
        group, artifact, version, token
    )


}