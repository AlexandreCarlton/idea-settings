package com.github.alexandrecarlton.idea.settings.noop

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

/**
 * A [SettingsApplier] that deliberately does nothing.
 *
 * Useful when dealing with Settings that are just objects.
 */
class NoOpSettingsApplier<T> @Inject constructor(): SettingsApplier<T> {
    override fun apply(settings: T) {}
}
