package io.github.novolmob.gradle.tools.vcs.utils

import java.net.URI

object UriUtil {

    fun URI.getUrl(): String = "$scheme://$authority"

}