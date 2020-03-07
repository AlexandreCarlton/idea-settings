package com.github.alexandrecarlton.idea.settings.dialog.configurations.remote

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.RemoteSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.execution.remote.RemoteConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class RemoteSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<RemoteSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        runManager = RunManager.getInstance(project)
        settingsApplier = RemoteSettingsApplier(runManager, project)
    }

    @Test
    fun defaultRemoteApplied() {
        settingsApplier.apply(RemoteSettings(name = "Default Remote"))
        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Default Remote")
        assertThat(runnerAndConfigurationSettings).isNotNull()
    }

    @Test
    fun customRemoteApplied() {
        settingsApplier.apply(RemoteSettings(name = "Configured Remote", configuration = RemoteConfigurationSettings(host = "8.8.8.8", port = 5000)))
        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Configured Remote")
        assertThat(runnerAndConfigurationSettings).isNotNull
        assertThat(runnerAndConfigurationSettings!!.configuration).isInstanceOf(RemoteConfiguration::class.java)
        val remoteConfiguration = runnerAndConfigurationSettings.configuration as RemoteConfiguration
        assertThat(remoteConfiguration.HOST).isEqualTo("8.8.8.8")
        assertThat(remoteConfiguration.PORT).isEqualTo("5000")
    }
}
