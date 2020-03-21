package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import javax.inject.Inject

class MavenImportingSettingsApplier @Inject
constructor(private val mavenImportingSettings: org.jetbrains.idea.maven.project.MavenImportingSettings) : SettingsApplier<MavenImportingSettings> {

    override fun apply(settings: MavenImportingSettings) {
        // Setting this to true causes IntelliJ IDEA to hang.
        // The method itself fires off listeners, but even if we set this reflectively, it still
        // prevents us from shutting down.
        // :wsettings.importMavenProjectsAutomatically?.let { mavenImportingSettings.isImportAutomatically = it }
        settings.vmOptionsForImporter?.let { mavenImportingSettings.vmOptionsForImporter = it }
    }
}