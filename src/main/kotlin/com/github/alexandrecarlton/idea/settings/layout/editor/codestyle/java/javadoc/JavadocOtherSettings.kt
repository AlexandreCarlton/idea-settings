package com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.javadoc

import com.fasterxml.jackson.annotation.JsonProperty

data class JavadocOtherSettings(

    @JsonProperty("Wrap at right margin")
    val wrapAtRightMargin: Boolean? = null,

    @JsonProperty("Enable leading asterisks")
    val enableLeadingAsterisks: Boolean? = null,

    @JsonProperty("Use @throws rather than @exception")
    val useThrowsRatherThanException: Boolean? = null,

    @JsonProperty("Generate '<p>' on empty lines")
    val generatePOnEmptyLines: Boolean? = null,

    @JsonProperty("Keep empty lines")
    val keepEmptyLines: Boolean? = null,

    @JsonProperty("Do not wrap one line comments")
    val doNotWrapOneLineComments: Boolean? = null,

    @JsonProperty("Preserve line feeds")
    val preserveLineFeeds: Boolean? = null,

    @JsonProperty("Parameter descriptions on new line")
    val parameterDescriptionsOnNewLine: Boolean? = null,

    @JsonProperty("Indent continuation lines")
    val indentContinuationLines: Boolean? = null
)
