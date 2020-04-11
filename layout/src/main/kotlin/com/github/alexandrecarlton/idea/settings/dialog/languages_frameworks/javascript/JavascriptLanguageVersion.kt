package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript

import com.fasterxml.jackson.annotation.JsonProperty

enum class JavascriptLanguageVersion {

    @JsonProperty("ECMAScript 5.1")
    ECMASCRIPT_5_1,

    @JsonProperty("JavaScript 1.8.5")
    JAVASCRIPT_1_8_5,

    @JsonProperty("ECMAScript 6")
    ECMASCRIPT_6,

    @JsonProperty("React JSX")
    REACT_JSX,

    @JsonProperty("Nashorn JS")
    NASHORN_JS,

    @JsonProperty("Flow")
    FLOW
}
