package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot;

import static java.util.stream.Collectors.toList;

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationEnvironmentSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationSpringBootSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.openapi.project.Project;
import com.intellij.spring.boot.run.SpringBootAdditionalParameter;
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType;
import com.intellij.spring.boot.run.SpringBootApplicationRunConfiguration;
import javax.inject.Inject;

public class SpringBootSettingsApplier implements SettingsApplier<SpringBootSettings> {

  private final Project project;
  private final RunManager runManager;

  @Inject
  public SpringBootSettingsApplier(Project project, RunManager runManager) {
    this.project = project;
    this.runManager = runManager;
  }

  @Override
  public void apply(SpringBootSettings settings) {
    SpringBootApplicationRunConfiguration configuration = new SpringBootApplicationRunConfiguration(
      project,
      new SpringBootApplicationConfigurationType().getDefaultConfigurationFactory(),
      settings.name());
    configuration.setMainClassName(settings.configuration().mainClass());
    settings.configuration().environment().ifPresent(env -> setSpringBootEnvironment(configuration, env));
    settings.configuration().springBoot().ifPresent(config -> setSpringBootConfiguration(configuration, config));
    RunnerAndConfigurationSettings runnerAndConfigurationSettings = runManager.createConfiguration(configuration, new SpringBootApplicationConfigurationType().getDefaultConfigurationFactory());
    runManager.addConfiguration(runnerAndConfigurationSettings);
  }

  private void setSpringBootEnvironment(SpringBootApplicationRunConfiguration configuration,
                                        SpringBootConfigurationEnvironmentSettings settings) {
    settings
      .includeDependenciesWithProvidedScope()
      .ifPresent(configuration::setIncludeProvidedScope);
    settings
      .useClassPathOfModule()
      .ifPresent(configuration::setModuleName);
    settings
      .vmOptions()
      .ifPresent(configuration::setVMParameters);
  }

  private void setSpringBootConfiguration(SpringBootApplicationRunConfiguration configuration,
                                          SpringBootConfigurationSpringBootSettings settings) {
    configuration.setAdditionalParameters(settings
      .overrideParameters()
      .stream()
      .map(parameter -> new SpringBootAdditionalParameter(true, parameter.name(), parameter.value()))
      .collect(toList()));
  }
}
