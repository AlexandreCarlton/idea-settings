package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DockerPortBindingProtocol {

  @JsonProperty("tcp")
  TCP,

  @JsonProperty("udp")
  UDP

}
