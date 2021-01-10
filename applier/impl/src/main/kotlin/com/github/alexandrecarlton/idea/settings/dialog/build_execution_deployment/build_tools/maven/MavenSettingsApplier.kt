package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class MavenSettingsApplier @Inject constructor(
    private val mavenImportingSettingsApplier: SettingsApplier<MavenImportingSettings>
) : SettingsApplier<MavenSettings> {

    override fun apply(settings: MavenSettings) {
        settings.importing?.let(mavenImportingSettingsApplier::apply)
    }
}
