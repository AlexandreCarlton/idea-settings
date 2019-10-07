package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle;

import static java.util.stream.Collectors.toCollection;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleConfigurationFile;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.intellij.openapi.project.Project;

import org.infernus.idea.checkstyle.config.PluginConfigurationBuilder;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;
import org.infernus.idea.checkstyle.model.ConfigurationLocation;
import org.infernus.idea.checkstyle.model.ConfigurationLocationFactory;
import org.infernus.idea.checkstyle.model.ConfigurationType;
import org.infernus.idea.checkstyle.model.ScanScope;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.TreeSet;

import javax.inject.Inject;

public class CheckstyleSettingsApplier implements SettingsApplier<CheckstyleSettings> {

  private static final String BUNDLED_LOCATION = "bundled";

  private final Project project;
  private final PluginConfigurationManager pluginConfigurationManager;

  @Inject
  public CheckstyleSettingsApplier(Project project, PluginConfigurationManager pluginConfigurationManager) {
    this.project = project;
    this.pluginConfigurationManager = pluginConfigurationManager;
  }

  @Override
  public void apply(CheckstyleSettings settings) {
    final PluginConfigurationBuilder builder = PluginConfigurationBuilder.from(pluginConfigurationManager.getCurrent());
    settings.checkstyleVersion().ifPresent(builder::withCheckstyleVersion);
    settings.scanScope().map(CheckstyleSettingsApplier::toScanScope).ifPresent(builder::withScanScope);
    settings.treatCheckstyleErrorsAsWarnings().ifPresent(builder::withSuppressErrors);
    builder.withLocations(settings.configurationFiles()
        .stream()
        .map(this::toConfigurationLocation)
        .collect(toCollection(TreeSet::new)));
    settings.configurationFiles()
        .stream()
        .filter(CheckstyleConfigurationFile::active)
        .map(this::toConfigurationLocation)
        .findFirst()
        .ifPresent(builder::withActiveLocation);
    pluginConfigurationManager.setCurrent(builder.build(), true);
  }

  private static ScanScope toScanScope(CheckstyleScanScope scanScope) {
    switch (scanScope) {
      case ONLY_JAVA_SOURCES_BUT_NOT_TESTS: return ScanScope.JavaOnly;
      case ONLY_JAVA_SOURCES_INCLUDING_TESTS: return ScanScope.JavaOnlyWithTests;
      case ALL_SOURCES_BUT_NOT_TESTS: return ScanScope.AllSources;
      case ALL_SOURCES_INCLUDING_TESTS: return ScanScope.AllSourcesWithTests;
      case ALL_FILES_IN_PROJECT: return ScanScope.AllSources;
      default: throw new IllegalArgumentException("Unhandled Scan Scope: " + scanScope);
    }
  }

  private ConfigurationLocation toConfigurationLocation(CheckstyleConfigurationFile configurationFile) {
    return new ConfigurationLocationFactory().create(
        project,
        toConfigurationType(configurationFile.file()),
        toLocation(configurationFile.file()),
        configurationFile.description());
  }


  private static ConfigurationType toConfigurationType(String location) {
    if (location.equals(BUNDLED_LOCATION)) {
      return ConfigurationType.BUNDLED;
    } else if (isURL(location)) {
      return ConfigurationType.HTTP_URL;
    }
    return Paths.get(location).isAbsolute()
        ? ConfigurationType.LOCAL_FILE
        : ConfigurationType.PROJECT_RELATIVE;
  }

  private String toLocation(String location) {
    if (location.equals(BUNDLED_LOCATION) || isURL(location) || Paths.get(location).isAbsolute()) {
      return location;
    } else {
      return Paths.get(project.getBasePath()).resolve(location).toAbsolutePath().toString();
    }
  }

  private static boolean isURL(String url) {
    try {
      new URL(url);
      return true;
    } catch (MalformedURLException e) {
      return false;
    }
  }

}
