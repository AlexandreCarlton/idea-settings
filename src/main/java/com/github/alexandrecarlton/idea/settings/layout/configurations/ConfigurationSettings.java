package com.github.alexandrecarlton.idea.settings.layout.configurations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.remote.RemoteSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.shell_script.ShellScriptConfigurationSettings;
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings;
import java.util.List;
import java.util.Optional;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
  @JsonSubTypes.Type(name = "dockerCompose", value = DockerComposeConfigurationSettings.class),
  @JsonSubTypes.Type(name = "dockerImage", value = DockerImageConfigurationSettings.class),
  @JsonSubTypes.Type(name = "remote", value = RemoteSettings.class),
  @JsonSubTypes.Type(name = "shellScript", value = ShellScriptConfigurationSettings.class),
  @JsonSubTypes.Type(name = "springBoot", value = SpringBootSettings.class)})
public interface ConfigurationSettings {

  String name();

  Optional<Boolean> shareThroughVcs();

  Optional<List<BeforeLaunchConfigurationSettings>> beforeLaunch();

}
