package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import org.jetbrains.idea.maven.project.MavenGeneralSettings
import javax.inject.Inject

class MavenSettingsApplier @Inject
constructor(
    private val mavenGeneralSettings: MavenGeneralSettings,
    private val mavenImportingSettingsApplier: SettingsApplier<MavenImportingSettings>) : SettingsApplier<MavenSettings> {

    override fun apply(settings: MavenSettings) {
        settings.importing?.let(mavenImportingSettingsApplier::apply)
        settings.mavenHomeDirectory?.let { mavenGeneralSettings.mavenHome = it.absolutePath }
        settings.threadCount?.let { mavenGeneralSettings.threads = it }
    }
}
