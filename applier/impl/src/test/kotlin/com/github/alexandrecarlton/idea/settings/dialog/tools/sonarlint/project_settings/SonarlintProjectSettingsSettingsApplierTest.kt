package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class SonarlintProjectSettingsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SonarlintProjectSettingsSettings>

    @Before
    public override fun setUp() {
        settingsApplier = SonarlintProjectSettingsSettingsApplier(project, platform.sonarLintProjectSettings)
    }

    @Test
    fun bindProjectToSonarQubeSonarCloudApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                bindProjectToSonarqubeSonarCloud = true)))
        assertThat(platform.sonarLintProjectSettings.isBindingEnabled).isTrue()
    }

    @Test
    fun connectionApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                projectBinding = ProjectBindingSettings(
                    connection = "My Sonar Instance"))))
        assertThat(platform.sonarLintProjectSettings.connection).isEqualTo("My Sonar Instance")
    }

    @Test
    fun projectApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            bindToToSonarQubeSonarCloud = BindToSonarQubeSonarCloudSettings(
                projectBinding = ProjectBindingSettings(
                    project = "my_project"))))
        assertThat(platform.sonarLintProjectSettings.projectKey).isEqualTo("my_project")
    }

    @Test
    fun fileExclusionApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            fileExclusions = listOf(
                ExcludeFile(File("${project.basePath}/excluded.txt")))))
        assertThat(platform.sonarLintProjectSettings.fileExclusions).containsExactly("FILE:excluded.txt")
    }

    @Test
    fun directoryExclusionApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            fileExclusions = listOf(
                ExcludeDirectory(File("${project.basePath}/excluded")))))
        assertThat(platform.sonarLintProjectSettings.fileExclusions).containsExactly("DIRECTORY:excluded")
    }

    @Test
    fun globExclusionApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            fileExclusions = listOf(
                ExcludeUsingGlobPattern("**/*.txt"))))
        assertThat(platform.sonarLintProjectSettings.fileExclusions).containsExactly("GLOB:**/*.txt")
    }

    @Test
    fun analysisPropertiesApplied() {
        settingsApplier.apply(SonarlintProjectSettingsSettings(
            analysisProperties = listOf(
                SonarlintAnalysisProperty(
                    propertyName = "Foo",
                    value = "Bar"))))
        assertThat(platform.sonarLintProjectSettings.additionalProperties).containsAllEntriesOf(mapOf(
            "Foo" to "Bar"))
    }
}
