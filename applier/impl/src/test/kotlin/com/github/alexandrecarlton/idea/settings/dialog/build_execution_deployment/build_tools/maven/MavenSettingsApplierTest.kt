package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class MavenSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<MavenSettings>
    private val mavenImportingSettingsApplier = mockk<SettingsApplier<MavenImportingSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        settingsApplier = MavenSettingsApplier(platform.mavenGeneralSettings, mavenImportingSettingsApplier)
    }

    @Test
    fun vmOptionsForImporterApplied() {
        settingsApplier.apply(MavenSettings(mavenHomeDirectory = File("/usr")))
        assertThat(platform.mavenGeneralSettings.mavenHome).isEqualTo("/usr")
    }

    @Test
    fun importSettingsApplied() {
        settingsApplier.apply(MavenSettings(importing = MavenImportingSettings()))
        verify { mavenImportingSettingsApplier.apply(MavenImportingSettings()) }
    }

    @Test
    fun threadCountApplied() {
        settingsApplier.apply(MavenSettings(threadCount = "1C"))
        assertThat(platform.mavenGeneralSettings.threads).isEqualTo("1C")
    }
}
