package ru.novolmob.gradle.tools.vcs.publication

import ru.novolmob.gradle.tools.vcs.storage.PublishingStorage

class VcsPublishingImpl(
    private val storage: PublishingStorage<Publication<*>>
): VcsPublishing {
    override fun add(value: Publication<*>) = storage.add(value)
    override fun addAll(values: List<Publication<*>>) = storage.addAll(values)

}