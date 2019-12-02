package com.github.alexandrecarlton.idea.settings.applier.api

interface SettingsApplier<T> {
    fun apply(settings: T)
}
