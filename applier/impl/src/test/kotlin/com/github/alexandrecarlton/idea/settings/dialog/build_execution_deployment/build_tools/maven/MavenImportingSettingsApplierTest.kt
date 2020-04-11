package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class MavenImportingSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<MavenImportingSettings>

    @Before
    public override fun setUp() {
        settingsApplier = MavenImportingSettingsApplier(platform.mavenImportingSettings)
    }

    @Test
    fun vmOptionsForImporterApplied() {
        settingsApplier.apply(MavenImportingSettings(vmOptionsForImporter = "-Xmx3g"))
        assertThat(platform.mavenImportingSettings.vmOptionsForImporter).isEqualTo("-Xmx3g")
    }
}
