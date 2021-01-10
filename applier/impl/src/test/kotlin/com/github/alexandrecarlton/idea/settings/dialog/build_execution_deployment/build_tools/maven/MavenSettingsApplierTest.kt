package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MavenSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<MavenSettings>
    private val mavenImportingSettingsApplier = mockk<SettingsApplier<MavenImportingSettings>>(relaxUnitFun = true)

    @Before
    public override fun setUp() {
        settingsApplier = MavenSettingsApplier(mavenImportingSettingsApplier)
    }

    @Test
    fun importSettingsApplied() {
        settingsApplier.apply(MavenSettings(importing = MavenImportingSettings()))
        verify { mavenImportingSettingsApplier.apply(MavenImportingSettings()) }
    }
}
