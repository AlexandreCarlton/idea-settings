package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.ImmutableMavenImportingSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings
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
        settingsApplier.apply(ImmutableMavenImportingSettings.builder()
                .vmOptionsForImporter("-Xmx3g")
                .build())
        assertThat(mavenImportingSettings.vmOptionsForImporter).isEqualTo("-Xmx3g")
    }

}
