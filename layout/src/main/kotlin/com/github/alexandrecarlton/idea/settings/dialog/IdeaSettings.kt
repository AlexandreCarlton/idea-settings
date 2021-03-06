package com.github.alexandrecarlton.idea.settings.dialog

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.EditorSettings
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.LanguagesFrameworksSettings
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.dialog.tools.ToolsSettings

// TODO: This should have three top level properties:
// - Project Structure
// - Settings
// - Configurations
data class IdeaSettings(

    @JsonProperty("Editor")
    val editor: EditorSettings? = null,

    @JsonProperty("Build, Execution, Deployment")
    val buildExecutionDeployment: BuildExecutionDeploymentSettings? = null,

    @JsonProperty("Languages & Frameworks")
    val languagesFrameworks: LanguagesFrameworksSettings? = null,

    @JsonProperty("Tools")
    val tools: ToolsSettings? = null,

    @JsonProperty("Other Settings")
    val otherSettings: OtherSettings? = null,

    @JsonProperty("Project Settings")
    val projectSettings: ProjectSettingsSettings? = null,

    @JsonProperty("Run/Debug Configurations")
    val configurations: List<ConfigurationSettings>? = null
)

