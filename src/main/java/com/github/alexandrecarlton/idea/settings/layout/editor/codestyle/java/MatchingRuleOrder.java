package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MatchingRuleOrder {

  @JsonProperty("keep order")
  KEEP_ORDER,

  @JsonProperty("order by name")
  ORDER_BY_NAME

}
