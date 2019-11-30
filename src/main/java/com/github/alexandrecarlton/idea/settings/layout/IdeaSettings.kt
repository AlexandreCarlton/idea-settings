package com.github.alexandrecarlton.idea.settings.layout

import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings

data class IdeaSettings(

    val editor: EditorSettings? = null,

    val buildExecutionDeployment: BuildExecutionDeploymentSettings? = null,

    val languagesFrameworks: LanguagesFrameworksSettings? = null,

    val tools: ToolsSettings? = null,

    val otherSettings: OtherSettings? = null,

    val projectSettings: ProjectSettingsSettings? = null,

    val configurations: List<ConfigurationSettings>? = null
)

