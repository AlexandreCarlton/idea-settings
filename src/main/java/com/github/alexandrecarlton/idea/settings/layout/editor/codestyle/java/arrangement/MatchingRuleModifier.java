package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MatchingRuleModifier {
  @JsonProperty("abstract")
  ABSTRACT,

  @JsonProperty("final")
  FINAL,

  @JsonProperty("package private")
  PACKAGE_PRIVATE,

  @JsonProperty("private")
  PRIVATE,

  @JsonProperty("protected")
  PROTECTED,

  @JsonProperty("public")
  PUBLIC,

  @JsonProperty("not abstract")
  NOT_ABSTRACT,

  @JsonProperty("not final")
  NOT_FINAL,

  @JsonProperty("not package private")
  NOT_PACKAGE_PRIVATE,

  @JsonProperty("not private")
  NOT_PRIVATE,

  @JsonProperty("not protected")
  NOT_PROTECTED,

  @JsonProperty("not public")
  NOT_PUBLIC,

  @JsonProperty("not static")
  NOT_STATIC,

  @JsonProperty("not synchronized")
  NOT_SYNCHRONIZED,

  @JsonProperty("not transient")
  NOT_TRANSIENT,

  @JsonProperty("not volatile")
  NOT_VOLATILE,

  @JsonProperty("static")
  STATIC,

  @JsonProperty("synchronized")
  SYNCHRONIZED,

  @JsonProperty("transient")
  TRANSIENT,

  @JsonProperty("volatile")
  VOLATILE,

}
