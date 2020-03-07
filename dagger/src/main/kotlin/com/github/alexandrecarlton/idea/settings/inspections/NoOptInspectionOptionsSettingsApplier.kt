package com.github.alexandrecarlton.idea.settings.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class NoOpInspectionOptionsSettingsApplier<T> @Inject constructor(): SettingsApplier<T> {
    override fun apply(settings: T) {}
}
