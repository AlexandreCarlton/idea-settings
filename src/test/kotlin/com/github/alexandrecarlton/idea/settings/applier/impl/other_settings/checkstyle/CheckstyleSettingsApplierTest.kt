package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.ImmutableCheckstyleConfigurationFile
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.ImmutableCheckstyleSettings
import org.assertj.core.api.Assertions.assertThat
import org.infernus.idea.checkstyle.config.PluginConfigurationManager
import org.infernus.idea.checkstyle.model.ConfigurationType
import org.infernus.idea.checkstyle.model.ScanScope
import org.junit.Before
import org.junit.Test

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
        settingsApplier.apply(ImmutableCheckstyleSettings.builder()
            .checkstyleVersion("8.16")
            .build())
        assertThat(pluginConfigurationManager.current.checkstyleVersion).isEqualTo("8.16")
    }

    @Test
    fun scanScopeApplied() {
        settingsApplier.apply(ImmutableCheckstyleSettings.builder()
            .scanScope(CheckstyleScanScope.ONLY_JAVA_SOURCES_INCLUDING_TESTS)
            .build())
        assertThat(pluginConfigurationManager.current.scanScope)
            .isEqualTo(ScanScope.JavaOnlyWithTests)
    }

    @Test
    fun treatCheckstyleErrorsAsWarningsApplied() {
        settingsApplier.apply(ImmutableCheckstyleSettings.builder()
            .treatCheckstyleErrorsAsWarnings(true)
            .build())
        assertThat(pluginConfigurationManager.current.isSuppressErrors)
            .isEqualTo(true)
    }

    @Test
    fun localConfigurationFileApplied() {
        settingsApplier.apply(ImmutableCheckstyleSettings.builder()
            .addConfigurationFiles(ImmutableCheckstyleConfigurationFile.builder()
                .active(true)
                .description("My CheckStyle")
                .file("checkstyle.xml")
                .build())
            .build())

        val activeLocation = pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.PROJECT_RELATIVE)
        assertThat(activeLocation.location).isEqualTo(project.basePath + "/checkstyle.xml")
        assertThat(activeLocation.description).isEqualTo("My CheckStyle")
    }

    @Test
    fun bundledConfigurationFileApplied() {
        settingsApplier.apply(ImmutableCheckstyleSettings.builder()
            .addConfigurationFiles(ImmutableCheckstyleConfigurationFile.builder()
                .active(true)
                .description("Google Checks")
                .file("bundled")
                .build())
            .build())

        val activeLocation = pluginConfigurationManager.current.activeLocation!!
        assertThat(activeLocation.type).isEqualTo(ConfigurationType.BUNDLED)
        assertThat(activeLocation.description).isEqualTo("Google Checks")
    }
}
