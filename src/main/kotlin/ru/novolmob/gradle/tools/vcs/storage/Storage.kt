package ru.novolmob.gradle.tools.vcs.storage

interface Storage<T: Any> {

    fun add(value: T)
    fun addAll(values: List<T>)

}