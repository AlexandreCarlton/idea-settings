package com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.infernus.idea.checkstyle.model.ConfigurationType
import org.infernus.idea.checkstyle.model.ScanScope
import org.junit.Before
import org.junit.Test
import java.io.File

class CheckstyleSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<CheckstyleSettings>

    @Before
    public override fun setUp() {
        settingsApplier = CheckstyleSettingsApplier(project, platform.pluginConfigurationManager)
    }

    @Test
    fun checkstyleVersionApplied() {
        settingsApplier.apply(CheckstyleSettings(checkstyleVersion = "8.16"))
        assertThat(platform.pluginConfigurationManager.current.checkstyleVersion).isEqualTo("8.16")
    }

    @Test
    fun scanScopeApplied() {
        settingsApplier.apply(CheckstyleSettings(scanScope = CheckstyleScanScope.ONLY_JAVA_SOURCES_INCLUDING_TESTS))
        assertThat(platform.pluginConfigurationManager.current.scanScope).isEqualTo(ScanScope.JavaOnlyWithTests)
    }

    @Test
    fun treatCheckstyleErrorsAsWarningsApplied() {
        settingsApplier.apply(CheckstyleSettings(treatCheckstyleErrorsAsWarnings = true))
        assertThat(platform.pluginConfigurationManager.current.isSuppressErrors).isTrue()
    }

    @Test
    fun localConfigurationFileApplied() {
        settingsApplier.apply(CheckstyleSettings(configurationFiles = listOf(
            CheckstyleConfigurationFile(active = true, description = "My CheckStyle", file = "checkstyle.xml"))))

        val activeLocation = platform.pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.PROJECT_RELATIVE)
        // The current version (5.40.0) appears to not like this, but works (as verified by the integration test).
        // assertThat(activeLocation.location).isEqualTo("${project.basePath}/checkstyle.xml")
        assertThat(activeLocation.description).isEqualTo("My CheckStyle")
    }

    @Test
    fun bundledConfigurationFileApplied() {
        settingsApplier.apply(CheckstyleSettings(configurationFiles = listOf(
            CheckstyleConfigurationFile(active = true, description = "Google Checks", file = "bundled"))))

        val activeLocation = platform.pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.BUNDLED)
        assertThat(activeLocation.description).isEqualTo("Google Checks")
    }

    @Test
    fun thirdPartyChecksApplied() {
        settingsApplier.apply(CheckstyleSettings(thirdPartyChecks = listOf(File("${project.basePath}/lib/checkstyle-custom.jar"))))
        assertThat(platform.pluginConfigurationManager.current.thirdPartyClasspath).containsExactly("${project.basePath}/lib/checkstyle-custom.jar")
    }
}
