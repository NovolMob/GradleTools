package ru.novolmob.gradle.tools.vcs.storage

import ru.novolmob.gradle.tools.vcs.publication.Publication

interface PublishingStorage<T: Publication<*>>: Storage<T>