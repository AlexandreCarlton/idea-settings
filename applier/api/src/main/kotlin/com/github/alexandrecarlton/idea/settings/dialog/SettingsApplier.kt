package com.github.alexandrecarlton.idea.settings.dialog

interface SettingsApplier<T> {
    fun apply(settings: T)
}
