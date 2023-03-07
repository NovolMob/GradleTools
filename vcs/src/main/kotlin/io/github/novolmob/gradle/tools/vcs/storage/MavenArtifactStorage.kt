package io.github.novolmob.gradle.tools.vcs.storage

import io.github.novolmob.gradle.tools.vcs.common.MavenArtifact

interface MavenArtifactStorage<T: MavenArtifact>: Storage<T>