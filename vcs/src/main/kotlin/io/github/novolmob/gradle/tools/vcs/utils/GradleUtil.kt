package io.github.novolmob.gradle.tools.vcs.utils

import io.github.novolmob.gradle.tools.vcs.gitlab.GitlabToken
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.credentials.HttpHeaderCredentials
import org.gradle.api.publish.PublicationContainer
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.authentication.http.HttpHeaderAuthentication
import java.net.URI

object GradleUtil {

    fun RepositoryHandler.registerGitlabMavenArtifact(uri: String, token: GitlabToken) = maven {
        url = URI(uri)
        isAllowInsecureProtocol = true
        credentials(HttpHeaderCredentials::class.java) {
            name = token.name
            value = token.value
        }
        authentication {
            create("header", HttpHeaderAuthentication::class.java)
        }
    }

    fun PublicationContainer.registerGitlabPublication(group: String, artifact: String, version: String) =
        register(artifact, MavenPublication::class.java) {
            this.groupId = group
            this.artifactId = artifact
            this.version = version
        }

}