package io.github.novolmob.gradle.tools.vcs.gitlab

open class GitlabToken(val name: String, val value: String) {

    class Private(value: String): GitlabToken(PRIVATE_TOKEN_NAME, value)
    class Deploy(value: String): GitlabToken(DEPLOY_TOKEN_NAME, value)
    class Job(value: String): GitlabToken(JOB_TOKEN_NAME, value)

    companion object {
        const val PRIVATE_TOKEN_NAME = "Private-Token"
        const val DEPLOY_TOKEN_NAME = "Deploy-Token"
        const val JOB_TOKEN_NAME = "Job-Token"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is GitlabToken) return false
        return name == other.name && value == other.value
    }

}