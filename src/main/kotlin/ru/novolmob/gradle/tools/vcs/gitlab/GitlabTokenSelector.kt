package ru.novolmob.gradle.tools.vcs.gitlab

import ru.novolmob.gradle.tools.vcs.utils.GitUtil
import ru.novolmob.gradle.tools.vcs.utils.GitlabUtil

interface GitlabTokenSelector {
    fun token(token: GitlabToken)
}

fun GitlabTokenSelector.token(tokenName: String, token: String) = token(GitlabToken(tokenName, token))
fun GitlabTokenSelector.privateToken(token: String) = token(GitlabToken.Private(token))
fun GitlabTokenSelector.deployToken(token: String) = token(GitlabToken.Deploy(token))
fun GitlabTokenSelector.gitlabPrivateToken() = privateToken(GitlabUtil.getGitlabPrivateToken())
fun GitlabTokenSelector.gitlabDeployToken() = deployToken(GitlabUtil.getGitlabDeployToken())
fun GitlabTokenSelector.userTokenAsPrivateToken() = privateToken(GitUtil.getUserToken())
fun GitlabTokenSelector.userTokenAsDeployToken() = deployToken(GitUtil.getUserToken())
