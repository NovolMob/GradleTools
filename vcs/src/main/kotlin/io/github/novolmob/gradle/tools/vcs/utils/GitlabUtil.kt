package io.github.novolmob.gradle.tools.vcs.utils

import io.github.novolmob.gradle.tools.vcs.gitlab.GitlabToken
import io.github.novolmob.gradle.tools.vcs.utils.GitlabTokenUtil.token
import io.github.novolmob.gradle.tools.vcs.utils.StringUtil.getIDFromJson
import io.github.novolmob.gradle.tools.vcs.utils.StringUtil.replaceToHtmlSlash
import io.github.novolmob.gradle.tools.vcs.utils.StringUtil.toUri
import io.github.novolmob.gradle.tools.vcs.utils.UriUtil.getUrl
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object GitlabUtil {

    private const val GITLAB_URI_KEY = "gitlab.url"
    private const val GITLAB_PRIVATE_TOKEN_KEY = "gitlab.token.private"
    private const val GITLAB_DEPLOY_TOKEN_KEY = "gitlab.token.deploy"
    private const val GITLAB_JOB_TOKEN_KEY = "gitlab.token.job"

    fun requestGetToGitlab(uri: String, token: GitlabToken): String =
        HttpClient.newHttpClient()
            .sendAsync(
                HttpRequest.newBuilder(URI(uri))
                    .token(token)
                    .build(),
                HttpResponse.BodyHandlers.ofString()
            )
            .thenApply { it.body() }
            .join()!!

    fun getProjectId(gitlabUrl: String, projectName: String, token: GitlabToken): Int =
        requestGetToGitlab(
            "$gitlabUrl/api/v4/projects/${projectName.replaceToHtmlSlash()}",
            token
        ).let { it.getIDFromJson() ?: throw Exception("Project $projectName not found! Server response: $it") }

    fun getGroupId(gitlabUrl: String, groupName: String, token: GitlabToken): Int =
        requestGetToGitlab(
            "$gitlabUrl/api/v4/groups/${groupName.replaceToHtmlSlash()}",
            token
        ).let { it.getIDFromJson() ?: throw Exception("Group $groupName not found! Server response: $it") }

    fun getGitlabUrl(): String = GitUtil.getFromConfig(GITLAB_URI_KEY).toUri().getUrl()

    fun getGitlabPrivateToken(): String = GitUtil.getFromConfig(GITLAB_PRIVATE_TOKEN_KEY)
    fun getGitlabDeployToken(): String = GitUtil.getFromConfig(GITLAB_DEPLOY_TOKEN_KEY)
    fun getGitlabJobToken(): String = GitUtil.getFromConfig(GITLAB_JOB_TOKEN_KEY)

}