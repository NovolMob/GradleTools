package io.github.novolmob.gradle.tools.vcs.gitlab

import io.github.novolmob.gradle.tools.vcs.utils.GitUtil
import io.github.novolmob.gradle.tools.vcs.utils.GitlabUtil

interface GitlabTokenSelector {
    fun token(token: GitlabToken)
}

fun GitlabTokenSelector.token(tokenName: String, token: String) = token(GitlabToken(tokenName, token))
fun GitlabTokenSelector.privateToken(token: String) = token(GitlabToken.Private(token))
fun GitlabTokenSelector.deployToken(token: String) = token(GitlabToken.Deploy(token))
fun GitlabTokenSelector.jobToken(token: String) = token(GitlabToken.Job(token))
fun GitlabTokenSelector.gitlabPrivateToken() = privateToken(GitlabUtil.getGitlabPrivateToken())
fun GitlabTokenSelector.gitlabDeployToken() = deployToken(GitlabUtil.getGitlabDeployToken())
fun GitlabTokenSelector.gitlabJobToken() = deployToken(GitlabUtil.getGitlabJobToken())
fun GitlabTokenSelector.userTokenAsPrivateToken() = privateToken(GitUtil.getUserToken())
fun GitlabTokenSelector.userTokenAsDeployToken() = deployToken(GitUtil.getUserToken())
fun GitlabTokenSelector.userTokenAsJobToken() = jobToken(GitUtil.getUserToken())
