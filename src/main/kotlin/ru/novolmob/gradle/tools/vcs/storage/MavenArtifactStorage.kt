package ru.novolmob.gradle.tools.vcs.storage

import ru.novolmob.gradle.tools.vcs.common.MavenArtifact

interface MavenArtifactStorage<T: MavenArtifact>: Storage<T>