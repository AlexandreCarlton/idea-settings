package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenImportingSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.maven.MavenSettings
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.idea.maven.project.MavenGeneralSettings
import org.jetbrains.idea.maven.project.MavenProjectsManager
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import java.io.File

class MavenSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<MavenSettings>
    private lateinit var mavenGeneralSettings: MavenGeneralSettings
    @Mock
    private lateinit var mavenImportingSettingsApplier: SettingsApplier<MavenImportingSettings>

    @Before
    public override fun setUp() {
        mavenGeneralSettings = MavenProjectsManager.getInstance(project).generalSettings
        settingsApplier = MavenSettingsApplier(mavenGeneralSettings, mavenImportingSettingsApplier)
    }

    @Test
    fun vmOptionsForImporterApplied() {
        settingsApplier.apply(MavenSettings(mavenHomeDirectory = File("/usr")))
        assertThat(mavenGeneralSettings.mavenHome).isEqualTo("/usr")
    }

    @Test
    fun importSettingsApplied() {
        settingsApplier.apply(MavenSettings(importing = MavenImportingSettings()))
        verify(mavenImportingSettingsApplier).apply(MavenImportingSettings())
    }
}
