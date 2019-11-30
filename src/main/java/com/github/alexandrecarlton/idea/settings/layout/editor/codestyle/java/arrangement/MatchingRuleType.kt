package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.arrangement

import com.fasterxml.jackson.annotation.JsonProperty

enum class MatchingRuleType {
    @JsonProperty("class")
    CLASS,

    @JsonProperty("constructor")
    CONSTRUCTOR,

    @JsonProperty("field")
    FIELD,

    @JsonProperty("enum")
    ENUM,

    @JsonProperty("getter")
    GETTER,

    @JsonProperty("initializer block")
    INITIALIZER_BLOCK,

    @JsonProperty("interface")
    INTERFACE,

    @JsonProperty("method")
    METHOD,

    @JsonProperty("not class")
    NOT_CLASS,

    @JsonProperty("not constructor")
    NOT_CONSTRUCTOR,

    @JsonProperty("not initializer block")
    NOT_INITIALIZER_BLOCK,

    @JsonProperty("not enum")
    NOT_ENUM,

    @JsonProperty("not field")
    NOT_FIELD,

    @JsonProperty("not interface")
    NOT_INTERFACE,

    @JsonProperty("not method")
    NOT_METHOD,

    @JsonProperty("overridden")
    OVERRIDDEN,

    @JsonProperty("setter")
    SETTER
}
