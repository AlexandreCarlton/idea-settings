package com.github.alexandrecarlton.idea.settings.layout.configurations.docker;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DockerPublishToHostInterface {
  @JsonProperty("All")
  ALL,

  @JsonProperty("Specify")
  SPECIFY
}
