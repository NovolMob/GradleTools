package ru.novolmob.gradle.tools.vcs.utils

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.net.URI

object StringUtil {

    fun String.getIDFromJson(): Int? = Json.parseToJsonElement(this).jsonObject["id"]?.jsonPrimitive?.int

    fun String.replaceToHtmlSlash(): String = replace("/", "%2F")

    fun String.toUri(): URI = URI(this)

    fun String.normalizeProjectFullName(): String =
        replace(Regex("\\.\\w+\$"), "")
            .replace(Regex("^/*"), "")

    fun String.getGroupProjectFromProjectFullName(): String = substring(0, lastIndexOf('/'))

}
