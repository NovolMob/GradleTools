package io.github.novolmob.gradle.tools.vcs.gitlab

import io.github.novolmob.gradle.tools.vcs.publication.Publication
import io.github.novolmob.gradle.tools.vcs.publication.VcsPublishing
import io.github.novolmob.gradle.tools.vcs.storage.PublishingStorage
import io.github.novolmob.gradle.tools.vcs.utils.GitUtil
import org.gradle.api.Action
import org.gradle.api.Project

open class GitlabPublishing(
    private val storage: PublishingStorage<Publication<*>>
): GitlabTokenSelector, UriSelector {

    private lateinit var gitlabUrl: String
    private lateinit var token: GitlabToken

    override fun token(token: GitlabToken) {
        this.token = token
    }

    override fun url(uri: String) {
        this.gitlabUrl = uri
    }

    private fun projectPublication(
        gitlabUrl: String,
        name: String,
        group: String,
        artifact: String,
        version: String,
        token: GitlabToken
    ) = storage.add(GitlabPublication.Project(gitlabUrl, name, group, artifact, version, token))

    fun projectPublication(name: String, group: String, artifact: String, version: String) =
        projectPublication(gitlabUrl, name, group, artifact, version, token)

    fun remoteProjectPublication(group: String, artifact: String, version: String) =
        GitUtil.getRemoteProject().let {
            projectPublication(it.first, it.second, group, artifact, version, token)
        }

    fun remoteProjectPublication(project: Project) =
        GitUtil.getRemoteProject().let {
            projectPublication(it.first, it.second, project.group.toString(), project.rootProject.name, project.version.toString(), token)
        }

    companion object {

        fun VcsPublishing.gitlab(action: Action<GitlabPublishing>) {
            val gitlabExtension = GitlabPublishing(this)
            action.execute(gitlabExtension)
        }

    }

}