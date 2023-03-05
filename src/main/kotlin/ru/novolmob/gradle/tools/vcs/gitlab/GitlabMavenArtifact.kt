package ru.novolmob.gradle.tools.vcs.gitlab

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact
import ru.novolmob.gradle.tools.vcs.utils.GitlabUtil
import ru.novolmob.gradle.tools.vcs.utils.GradleUtil.registerGitlabMavenArtifact

open class GitlabMavenArtifact(
    val uri: String,
    val token: GitlabToken
): MavenArtifact {

    override fun RepositoryHandler.register(): MavenArtifactRepository =
        registerGitlabMavenArtifact(uri, token)

    class Group(gitlabUrl: String, name: String, token: GitlabToken) : GitlabMavenArtifact(
        GitlabUtil.getGroupId(gitlabUrl, name, token).let {
            "$gitlabUrl/api/v4/groups/$it/-/packages/maven"
        },
        token
    )

    class Project(gitlabUrl: String, name: String, token: GitlabToken) : GitlabMavenArtifact(
        GitlabUtil.getProjectId(gitlabUrl, name, token).let {
            "$gitlabUrl/api/v4/projects/$it/packages/maven"
        },
        token
    )

    class Url(gitlabUrl: String, token: GitlabToken): GitlabMavenArtifact("$gitlabUrl/packages/maven", token)

}