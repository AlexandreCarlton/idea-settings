package com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings

data class JavaInspectionsSettings(
    @JsonProperty("Code style issues")
    val codeStyleIssues: JavaCodeStyleIssuesInspectionsSettings? = null
)
