package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ImmutableInterpreterConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ImmutableShellScriptConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.sh.run.ShRunConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

public class ShellScriptConfigurationSettingsApplierTest extends IdeaSettingsTestFixture {

  private SettingsApplier<ShellScriptConfigurationSettings> settingsApplier;
  private RunManager runManager;

  @Before
  public void setUp() {
    runManager = RunManager.getInstance(project);
    settingsApplier = new ShellScriptConfigurationSettingsApplier(project, runManager);
  }

  @Test
  public void simpleShellConfiguration() {
    settingsApplier.apply(ImmutableShellScriptConfigurationSettings.builder()
        .name("Simple Shell Configuration")
        .scriptPath(Paths.get("/usr/bin/foo"))
        .build());

    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName("Simple Shell Configuration");
    assertThat(runnerAndConfigurationSettings).isNotNull();
    RunConfiguration runConfiguration = runnerAndConfigurationSettings.getConfiguration();
    assertThat(runConfiguration).isNotNull();
    assertThat(runConfiguration).isInstanceOf(ShRunConfiguration.class);
    ShRunConfiguration shRunConfiguration = (ShRunConfiguration) runConfiguration;
    assertThat(invokeGetMethod(shRunConfiguration, "getScriptPath")).isEqualTo("/usr/bin/foo");
  }

  @Test
  public void fullShellConfiguration() {
    settingsApplier.apply(ImmutableShellScriptConfigurationSettings.builder()
        .name("Full Shell Configuration")
        .scriptPath(Paths.get("/usr/bin/foo"))
        .scriptOptions("bar")
        .interpreter(ImmutableInterpreterConfigurationSettings.builder()
            .interpreterPath(Paths.get("/bin/sh"))
            .interpreterOptions("-e")
            .build())
        .build());

    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.findConfigurationByName("Full Shell Configuration");
    ShRunConfiguration shRunConfiguration = (ShRunConfiguration) runnerAndConfigurationSettings.getConfiguration();
    assertThat(invokeGetMethod(shRunConfiguration, "getScriptPath")).isEqualTo("/usr/bin/foo");
    assertThat(invokeGetMethod(shRunConfiguration, "getScriptOptions")).isEqualTo("bar");
    assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterPath")).isEqualTo("/bin/sh");
    assertThat(invokeGetMethod(shRunConfiguration, "getInterpreterOptions")).isEqualTo("-e");
  }

  private String invokeGetMethod(ShRunConfiguration shRunConfiguration, String methodName) {
    try {
      final Method method = shRunConfiguration.getClass().getDeclaredMethod(methodName);
      method.setAccessible(true);
      return (String) method.invoke(shRunConfiguration);
    } catch ( IllegalAccessException | InvocationTargetException | NoSuchMethodException  e) {
      throw new RuntimeException("Unable to invoke method " + methodName + ".", e);
    }
  }
}
