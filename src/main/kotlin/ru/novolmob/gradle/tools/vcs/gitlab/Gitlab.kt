package ru.novolmob.gradle.tools.vcs.gitlab

import org.gradle.api.Action
import ru.novolmob.gradle.tools.vcs.common.MavenArtifact
import ru.novolmob.gradle.tools.vcs.storage.MavenArtifactStorage
import ru.novolmob.gradle.tools.vcs.extension.VcsExtension
import ru.novolmob.gradle.tools.vcs.utils.GitUtil
import ru.novolmob.gradle.tools.vcs.utils.StringUtil.getGroupProjectFromProjectFullName

open class Gitlab(
    private val storage: MavenArtifactStorage<MavenArtifact>
): GitlabTokenSelector, UriSelector {

    private lateinit var gitlabUrl: String
    private lateinit var token: GitlabToken

    fun groupArtifact(group: String) {
        groupArtifact(group, gitlabUrl, token)
    }
    fun projectArtifact(project: String) {
        projectArtifact(project, gitlabUrl, token)
    }
    fun urlArtifact() {
        urlArtifact(gitlabUrl, token)
    }

    fun remoteProjectGroupArtifact() =
        GitUtil.getRemoteProject().let {
            groupArtifact(it.first, it.second.getGroupProjectFromProjectFullName(), token)
        }
    fun remoteProjectArtifact() =
        GitUtil.getRemoteProject().let {
            projectArtifact(it.first, it.second, token)
        }

    private fun groupArtifact(gitlabUrl: String, group: String, token: GitlabToken) {
        storage.add(GitlabMavenArtifact.Group(gitlabUrl, group, token))
    }
    private fun projectArtifact(gitlabUrl: String, project: String, token: GitlabToken) {
        storage.add(GitlabMavenArtifact.Project(gitlabUrl, project, token))
    }
    private fun urlArtifact(gitlabUrl: String, token: GitlabToken) {
        storage.add(GitlabMavenArtifact.Url(gitlabUrl, token))
    }

    override fun token(token: GitlabToken) {
        this.token = token
    }

    override fun url(uri: String) {
        this.gitlabUrl = uri
    }

    companion object {

        fun VcsExtension.gitlab(action: Action<Gitlab>) {
            val gitlabExtension = Gitlab(mavenArtifactStorage)
            action.execute(gitlabExtension)
        }

    }

}