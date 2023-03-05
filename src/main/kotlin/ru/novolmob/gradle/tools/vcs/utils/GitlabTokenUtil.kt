package ru.novolmob.gradle.tools.vcs.utils

import ru.novolmob.gradle.tools.vcs.gitlab.GitlabToken
import java.net.http.HttpRequest

object GitlabTokenUtil {

    fun HttpRequest.Builder.token(token: GitlabToken) = header(token.name, token.value)

}