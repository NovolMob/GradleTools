package io.github.novolmob.gradle.tools.vcs.gitlab

import io.github.novolmob.gradle.tools.vcs.utils.GitUtil
import io.github.novolmob.gradle.tools.vcs.utils.GitlabUtil

interface UriSelector {
    fun url(uri: String)
}

fun UriSelector.remoteOriginUrl() {
    url(GitUtil.getRemoteOriginUrl())
}
fun UriSelector.gitlabUrl() {
    url(GitlabUtil.getGitlabUrl())
}