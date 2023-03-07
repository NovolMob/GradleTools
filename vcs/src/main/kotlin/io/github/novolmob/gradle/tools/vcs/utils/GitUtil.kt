package io.github.novolmob.gradle.tools.vcs.utils

import io.github.novolmob.gradle.tools.vcs.utils.StringUtil.normalizeProjectFullName
import io.github.novolmob.gradle.tools.vcs.utils.StringUtil.toUri
import io.github.novolmob.gradle.tools.vcs.utils.UriUtil.getUrl
import java.net.URI

object GitUtil {

    private const val REMOTE_ORIGIN_URI_KEY =  "remote.origin.url"
    private const val USER_TOKEN_KEY =  "user.token"

    fun getRemoteProject(): Pair<String, String> =
        URI(getRemoteOriginUri()).run {
            getUrl() to path.normalizeProjectFullName()
        }

    fun getRemoteOriginUrl(): String =
        getRemoteOriginUri().toUri().getUrl()

    fun getFromConfigOrNull(key: String): String? =
        CommandUtil.runCommand("git", "config", "--get", key)

    fun getFromConfig(key: String): String =
        getFromConfigOrNull(key) ?: throw Exception("Property $key not found in git config.")

    fun getRemoteOriginUri(): String = getFromConfig(REMOTE_ORIGIN_URI_KEY)

    fun getUserToken(): String = getFromConfig(USER_TOKEN_KEY)

}