package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.InterpreterConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.openapi.project.Project;
import com.intellij.sh.run.ShConfigurationType;
import com.intellij.sh.run.ShRunConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import javax.inject.Inject;

public class ShellScriptConfigurationSettingsApplier implements SettingsApplier<ShellScriptConfigurationSettings> {

  private final Project project;
  private final RunManager runManager;

  @Inject
  public ShellScriptConfigurationSettingsApplier(Project project, RunManager runManager) {
    this.project = project;
    this.runManager = runManager;
  }

  @Override
  public void apply(ShellScriptConfigurationSettings settings) {
    final ShRunConfiguration shRunConfiguration = (ShRunConfiguration) new ShConfigurationType().createTemplateConfiguration(project);
    shRunConfiguration.setName(settings.name());

    invokeSetMethod(shRunConfiguration, "setScriptPath", settings.scriptPath().toString());
    settings.scriptOptions()
        .ifPresent(scriptOptions -> invokeSetMethod(shRunConfiguration, "setScriptOptions", scriptOptions));
    settings.interpreter()
        .flatMap(InterpreterConfigurationSettings::interpreterPath)
        .map(Path::toString)
        .ifPresent(interpreterPath -> invokeSetMethod(shRunConfiguration, "setInterpreterPath", interpreterPath));
    settings.interpreter()
        .flatMap(InterpreterConfigurationSettings::interpreterOptions)
        .ifPresent(interpreterOptions -> invokeSetMethod(shRunConfiguration, "setInterpreterOptions", interpreterOptions));

    final RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.createConfiguration(shRunConfiguration, new ShConfigurationType());
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }

  private void invokeSetMethod(ShRunConfiguration shRunConfiguration, String methodName, String value) {
    try {
      final Method method = shRunConfiguration.getClass().getDeclaredMethod(methodName, String.class);
      method.setAccessible(true);
      method.invoke(shRunConfiguration, value);
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException("Unable to invoke method " + methodName + " with value " + value + ".", e);
    }
  }
}
