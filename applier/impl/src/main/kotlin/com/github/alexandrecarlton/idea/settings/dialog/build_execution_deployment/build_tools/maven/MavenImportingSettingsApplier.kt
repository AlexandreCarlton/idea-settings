package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class MavenImportingSettingsApplier @Inject
constructor(private val mavenImportingSettings: org.jetbrains.idea.maven.project.MavenImportingSettings) : SettingsApplier<MavenImportingSettings> {

    override fun apply(settings: MavenImportingSettings) {
        settings.vmOptionsForImporter?.let { mavenImportingSettings.vmOptionsForImporter = it }
    }
}
