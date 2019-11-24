package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.wrapping_and_braces;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Force {
  @JsonProperty("Do not force")
  DO_NOT_FORCE,

  @JsonProperty("When multiline")
  WHEN_MULTILINE,

  @JsonProperty("Always")
  ALWAYS
}
