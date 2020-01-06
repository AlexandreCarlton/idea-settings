package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleConfigurationFile
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope.ALL_FILES_IN_PROJECT
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope.ALL_SOURCES_BUT_NOT_TESTS
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope.ALL_SOURCES_INCLUDING_TESTS
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope.ONLY_JAVA_SOURCES_BUT_NOT_TESTS
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope.ONLY_JAVA_SOURCES_INCLUDING_TESTS
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings
import com.intellij.openapi.project.Project
import org.infernus.idea.checkstyle.config.PluginConfigurationBuilder
import org.infernus.idea.checkstyle.config.PluginConfigurationManager
import org.infernus.idea.checkstyle.model.ConfigurationLocationFactory
import org.infernus.idea.checkstyle.model.ConfigurationType
import org.infernus.idea.checkstyle.model.ScanScope
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.nio.file.Paths
import java.util.Collections.emptySortedSet
import javax.inject.Inject

class CheckstyleSettingsApplier @Inject
constructor(
    private val project: Project,
    private val pluginConfigurationManager: PluginConfigurationManager
) : SettingsApplier<CheckstyleSettings> {

    companion object {
        private const val BUNDLED_LOCATION = "bundled"
    }

    override fun apply(settings: CheckstyleSettings) {
        val builder = PluginConfigurationBuilder.from(pluginConfigurationManager.current)
        settings.checkstyleVersion?.let { builder.withCheckstyleVersion(it) }
        settings.scanScope?.let { builder.withScanScope(toScanScope(it)) }
        settings.treatCheckstyleErrorsAsWarnings?.let { builder.withSuppressErrors(it) }
        builder.withLocations(settings.configurationFiles?.map { toConfigurationLocation(it) }?.toSortedSet() ?: emptySortedSet())
        settings.configurationFiles?.firstOrNull { it.active }?.let { builder.withActiveLocation(toConfigurationLocation(it)) }
        settings.thirdPartyChecks?.map(File::toString)?.let { builder.withThirdPartyClassPath(it) }
        pluginConfigurationManager.setCurrent(builder.build(), true)
    }

    private fun toConfigurationLocation(configurationFile: CheckstyleConfigurationFile) =
        ConfigurationLocationFactory().create(
            project,
            toConfigurationType(configurationFile.file),
            toLocation(configurationFile.file),
            configurationFile.description)

    private fun toLocation(location: String) =
        if (location == BUNDLED_LOCATION || isURL(location) || Paths.get(location).isAbsolute) {
            location
        } else {
            Paths.get(project.basePath).resolve(location).toAbsolutePath().toString()
        }

    private fun toScanScope(scanScope: CheckstyleScanScope) =
        when (scanScope) {
            ONLY_JAVA_SOURCES_BUT_NOT_TESTS -> ScanScope.JavaOnly
            ONLY_JAVA_SOURCES_INCLUDING_TESTS -> ScanScope.JavaOnlyWithTests
            ALL_SOURCES_BUT_NOT_TESTS -> ScanScope.AllSources
            ALL_SOURCES_INCLUDING_TESTS -> ScanScope.AllSourcesWithTests
            ALL_FILES_IN_PROJECT -> ScanScope.AllSources
        }

    private fun toConfigurationType(location: String): ConfigurationType {
        if (location == BUNDLED_LOCATION) {
            return ConfigurationType.BUNDLED
        } else if (isURL(location)) {
            return ConfigurationType.HTTP_URL
        }
        return if (Paths.get(location).isAbsolute)
            ConfigurationType.LOCAL_FILE
        else
            ConfigurationType.PROJECT_RELATIVE
    }

    private fun isURL(url: String) =
        try {
            URL(url)
            true
        } catch (e: MalformedURLException) {
            false
        }
}
