package ru.novolmob.gradle.tools.vcs.gitlab

import ru.novolmob.gradle.tools.vcs.utils.GitUtil
import ru.novolmob.gradle.tools.vcs.utils.GitlabUtil

interface UriSelector {
    fun url(uri: String)
}

fun UriSelector.remoteOriginUrl() {
    url(GitUtil.getRemoteOriginUrl())
}
fun UriSelector.gitlabUrl() {
    url(GitlabUtil.getGitlabUrl())
}