package com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleScanScope;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.CheckstyleSettings;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.ImmutableCheckstyleConfigurationFile;
import com.github.alexandrecarlton.idea.settings.layout.other_settings.checkstyle.ImmutableCheckstyleSettings;
import org.infernus.idea.checkstyle.config.PluginConfigurationManager;
import org.infernus.idea.checkstyle.model.ConfigurationLocation;
import org.infernus.idea.checkstyle.model.ConfigurationType;
import org.infernus.idea.checkstyle.model.ScanScope;
import org.junit.Before;
import org.junit.Test;

public class CheckstyleSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<CheckstyleSettings> settingsApplier;
  private PluginConfigurationManager pluginConfigurationManager;

  @Before
  public void setUp() {
    pluginConfigurationManager = PluginConfigurationManager.getInstance(project);
    settingsApplier = new CheckstyleSettingsApplier(project, pluginConfigurationManager);
  }

  @Test
  public void checkstyleVersionApplied() {
    settingsApplier.apply(ImmutableCheckstyleSettings.builder()
        .checkstyleVersion("8.16")
        .build());
    assertThat(pluginConfigurationManager.getCurrent().getCheckstyleVersion()).isEqualTo("8.16");
  }

  @Test
  public void scanScopeApplied() {
    settingsApplier.apply(ImmutableCheckstyleSettings.builder()
        .scanScope(CheckstyleScanScope.ONLY_JAVA_SOURCES_INCLUDING_TESTS)
        .build());
    assertThat(pluginConfigurationManager.getCurrent().getScanScope())
        .isEqualTo(ScanScope.JavaOnlyWithTests);
  }

  @Test
  public void treatCheckstyleErrorsAsWarningsApplied() {
    settingsApplier.apply(ImmutableCheckstyleSettings.builder()
        .treatCheckstyleErrorsAsWarnings(true)
        .build());
    assertThat(pluginConfigurationManager.getCurrent().isSuppressErrors())
        .isEqualTo(true);
  }

  @Test
  public void localConfigurationFileApplied() {
    settingsApplier.apply(ImmutableCheckstyleSettings.builder()
        .addConfigurationFiles(ImmutableCheckstyleConfigurationFile.builder()
            .active(true)
            .description("My CheckStyle")
            .file("checkstyle.xml")
            .build())
        .build());

    final ConfigurationLocation activeLocation = pluginConfigurationManager.getCurrent().getActiveLocation();
    assertThat(activeLocation.getType()).isEqualTo(ConfigurationType.PROJECT_RELATIVE);
    assertThat(activeLocation.getLocation()).isEqualTo(project.getBasePath() + "/checkstyle.xml");
    assertThat(activeLocation.getDescription()).isEqualTo("My CheckStyle");
  }

  @Test
  public void bundledConfigurationFileApplied() {
    settingsApplier.apply(ImmutableCheckstyleSettings.builder()
        .addConfigurationFiles(ImmutableCheckstyleConfigurationFile.builder()
            .active(true)
            .description("Google Checks")
            .file("bundled")
            .build())
        .build());

    final ConfigurationLocation activeLocation = pluginConfigurationManager.getCurrent().getActiveLocation();
    assertThat(activeLocation.getType()).isEqualTo(ConfigurationType.BUNDLED);
    assertThat(activeLocation.getDescription()).isEqualTo("Google Checks");
  }

}
