package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class MavenImportingSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<MavenImportingSettings>
    private lateinit var mavenImportingSettings: org.jetbrains.idea.maven.project.MavenImportingSettings

    @Before
    public override fun setUp() {
        mavenImportingSettings = org.jetbrains.idea.maven.project.MavenProjectsManager.getInstance(project).importingSettings
        settingsApplier = MavenImportingSettingsApplier(mavenImportingSettings)
    }

    @Test
    fun vmOptionsForImporterApplied() {
        settingsApplier.apply(MavenImportingSettings(vmOptionsForImporter = "-Xmx3g"))
        assertThat(mavenImportingSettings.vmOptionsForImporter).isEqualTo("-Xmx3g")
    }
}
