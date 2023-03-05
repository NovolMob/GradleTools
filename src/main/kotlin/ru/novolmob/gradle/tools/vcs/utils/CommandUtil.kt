package ru.novolmob.gradle.tools.vcs.utils

object CommandUtil {
    fun runCommand(vararg command: String): String? = ProcessBuilder()
        .command(*command)
        .start()
        .inputStream
        .use { String(it.readAllBytes()).dropLast(1) }
        .takeIf { it.isNotEmpty() }
}