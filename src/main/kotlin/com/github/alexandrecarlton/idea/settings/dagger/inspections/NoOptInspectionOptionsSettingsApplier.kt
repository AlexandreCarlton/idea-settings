package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import javax.inject.Inject

class NoOpInspectionOptionsSettingsApplier<T> @Inject constructor(): SettingsApplier<T> {
    override fun apply(settings: T) {}
}
