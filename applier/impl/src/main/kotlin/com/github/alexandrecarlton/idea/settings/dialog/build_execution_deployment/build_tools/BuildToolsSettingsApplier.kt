package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenSettings
import javax.inject.Inject

class BuildToolsSettingsApplier
@Inject constructor(private val mavenSettingsApplier: SettingsApplier<MavenSettings>) : SettingsApplier<BuildToolsSettings> {

    override fun apply(settings: BuildToolsSettings) {
        settings.maven?.let(mavenSettingsApplier::apply)
    }
}
