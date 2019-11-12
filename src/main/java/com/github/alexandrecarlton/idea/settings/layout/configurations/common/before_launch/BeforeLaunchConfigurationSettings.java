package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(
  use = Id.NAME,
  include = As.WRAPPER_OBJECT)
@JsonSubTypes({
  @Type(name = "build", value = BuildConfigurationSettings.class),
  @Type(name = "runAnotherConfiguration", value = RunAnotherConfigurationSettings.class),
  @Type(name = "runMavenGoal", value = RunMavenGoalSettings.class)})
public interface BeforeLaunchConfigurationSettings {
}
