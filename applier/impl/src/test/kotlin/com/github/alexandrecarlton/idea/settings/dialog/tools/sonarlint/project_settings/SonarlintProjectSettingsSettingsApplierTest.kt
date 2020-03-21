package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.sonarlint.intellij.config.project.SonarLintProjectSettings

class SonarlintProjectSettingsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SonarlintProjectSettingsSettings>
    private lateinit var sonarLintProjectSettings: SonarLintProjectSettings

    @Before
    public override fun setUp() {
        sonarLintProjectSettings = project.getComponent(SonarLintProjectSettings::class.java)
        settingsApplier = SonarlintProjectSettingsSettingsApplier(sonarLintProjectSettings)
    }

    @Test
    fun bindProjectToSonarQubeSonarCloudApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                bindProjectToSonarqubeSonarCloud = true)))
        assertThat(sonarLintProjectSettings.isBindingEnabled).isTrue()
    }

    @Test
    fun connectionApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                projectBinding = ProjectBindingSettings(
                    connection = "My Sonar Instance"))))
        assertThat(sonarLintProjectSettings.serverId).isEqualTo("My Sonar Instance")
    }

    @Test
    fun projectApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                projectBinding = ProjectBindingSettings(
                    project = "my_project"))))
        assertThat(sonarLintProjectSettings.projectKey).isEqualTo("my_project")
    }
}
