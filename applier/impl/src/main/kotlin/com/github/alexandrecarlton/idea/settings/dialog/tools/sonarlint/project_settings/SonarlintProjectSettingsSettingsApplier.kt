package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import org.sonarlint.intellij.config.project.SonarLintProjectSettings
import javax.inject.Inject

class SonarlintProjectSettingsSettingsApplier @Inject constructor(
    private val sonarLintProjectSettings: SonarLintProjectSettings
) : SettingsApplier<SonarlintProjectSettingsSettings> {
    override fun apply(settings: SonarlintProjectSettingsSettings) {
        settings.bindToToSonarQubeSonarCloud?.bindProjectToSonarqubeSonarCloud?.let { sonarLintProjectSettings.isBindingEnabled = it }
        settings.bindToToSonarQubeSonarCloud?.projectBinding?.connection?.let { sonarLintProjectSettings.serverId = it }
        settings.bindToToSonarQubeSonarCloud?.projectBinding?.project?.let { sonarLintProjectSettings.projectKey = it }
    }
}
