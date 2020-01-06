package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleConfigurationFile
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.infernus.idea.checkstyle.config.PluginConfigurationManager
import org.infernus.idea.checkstyle.model.ConfigurationType
import org.infernus.idea.checkstyle.model.ScanScope
import org.junit.Before
import org.junit.Test
import java.io.File

class CheckstyleSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<CheckstyleSettings>
    private lateinit var pluginConfigurationManager: PluginConfigurationManager

    @Before
    public override fun setUp() {
        pluginConfigurationManager = PluginConfigurationManager.getInstance(project)
        settingsApplier = CheckstyleSettingsApplier(project, pluginConfigurationManager)
    }

    @Test
    fun checkstyleVersionApplied() {
        settingsApplier.apply(CheckstyleSettings(checkstyleVersion = "8.16"))
        assertThat(pluginConfigurationManager.current.checkstyleVersion).isEqualTo("8.16")
    }

    @Test
    fun scanScopeApplied() {
        settingsApplier.apply(CheckstyleSettings(scanScope = CheckstyleScanScope.ONLY_JAVA_SOURCES_INCLUDING_TESTS))
        assertThat(pluginConfigurationManager.current.scanScope).isEqualTo(ScanScope.JavaOnlyWithTests)
    }

    @Test
    fun treatCheckstyleErrorsAsWarningsApplied() {
        settingsApplier.apply(CheckstyleSettings(treatCheckstyleErrorsAsWarnings = true))
        assertThat(pluginConfigurationManager.current.isSuppressErrors).isTrue()
    }

    @Test
    fun localConfigurationFileApplied() {
        settingsApplier.apply(CheckstyleSettings(configurationFiles = listOf(
            CheckstyleConfigurationFile(active = true, description = "My CheckStyle", file = "checkstyle.xml"))))

        val activeLocation = pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.PROJECT_RELATIVE)
        assertThat(activeLocation.location).isEqualTo(project.basePath + "/checkstyle.xml")
        assertThat(activeLocation.description).isEqualTo("My CheckStyle")
    }

    @Test
    fun bundledConfigurationFileApplied() {
        settingsApplier.apply(CheckstyleSettings(configurationFiles = listOf(
            CheckstyleConfigurationFile(active = true, description = "Google Checks", file = "bundled"))))

        val activeLocation = pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.BUNDLED)
        assertThat(activeLocation.description).isEqualTo("Google Checks")
    }

    @Test
    fun thirdPartyChecksApplied() {
        settingsApplier.apply(CheckstyleSettings(thirdPartyChecks = listOf(File("${project.basePath}/lib/checkstyle-custom.jar"))))
        assertThat(pluginConfigurationManager.current.thirdPartyClasspath).containsExactly("${project.basePath}/lib/checkstyle-custom.jar")
    }
}
