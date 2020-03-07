package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.JavadocInspectionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsSettings

data class JavaInspectionsSettings(
    @JsonProperty("Code style issues")
    val codeStyleIssues: JavaCodeStyleIssuesInspectionsSettings? = null,

    @JsonProperty("Javadoc")
    val javadoc: JavadocInspectionsSettings? = null,

    @JsonProperty("Probable bugs")
    val probableBugs: JavaProbableBugsInspectionsSettings? = null
)
