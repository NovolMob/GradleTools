package io.github.novolmob.gradle.tools.vcs.storage

import io.github.novolmob.gradle.tools.vcs.publication.Publication

interface PublishingStorage<T: Publication<*>>: Storage<T>