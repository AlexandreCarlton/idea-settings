package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings

import javax.inject.Inject

class BuildToolsSettingsApplier
@Inject constructor(private val mavenSettingsApplier: SettingsApplier<MavenSettings>) : SettingsApplier<BuildToolsSettings> {

    override fun apply(settings: BuildToolsSettings) {
        settings.maven?.let(mavenSettingsApplier::apply)
    }
}
