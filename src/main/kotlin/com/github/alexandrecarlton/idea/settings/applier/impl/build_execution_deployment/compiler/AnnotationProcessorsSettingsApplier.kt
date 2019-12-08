package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.AnnotationProcessorsSettings

import javax.inject.Inject

class AnnotationProcessorsSettingsApplier
@Inject constructor() : SettingsApplier<AnnotationProcessorsSettings> {

    override fun apply(settings: AnnotationProcessorsSettings) {
        // No-op until we work out how to configure this.
        // Each module belongs to a profile, with a default profile.
    }
}