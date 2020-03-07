package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class AnnotationProcessorsSettingsApplier
@Inject constructor() : SettingsApplier<AnnotationProcessorsSettings> {

    override fun apply(settings: AnnotationProcessorsSettings) {
        // No-op until we work out how to configure this.
        // Each module belongs to a profile, with a default profile.
    }
}
