package com.github.alexandrecarlton.idea.settings.dialog

import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings
import javax.inject.Inject

class IdeaSettingsApplier @Inject
constructor(
    private val buildExecutionDeploymentSettingsApplier: SettingsApplier<BuildExecutionDeploymentSettings>,
    private val configurationsSettingsApplier: SettingsApplier<ConfigurationSettings>,
    private val editorSettingsApplier: SettingsApplier<EditorSettings>,
    private val languagesFrameworksSettingsApplier: SettingsApplier<LanguagesFrameworksSettings>,
    private val otherSettingsApplier: SettingsApplier<OtherSettings>,
    private val projectSettingsSettingsApplier: SettingsApplier<ProjectSettingsSettings>,
    private val toolsSettingsApplier: SettingsApplier<ToolsSettings>)
: SettingsApplier<IdeaSettings> {

    override fun apply(settings: IdeaSettings) {
        settings.buildExecutionDeployment?.let(buildExecutionDeploymentSettingsApplier::apply)
        settings.configurations?.forEach(configurationsSettingsApplier::apply)
        settings.editor?.let(editorSettingsApplier::apply)
        settings.languagesFrameworks?.let(languagesFrameworksSettingsApplier::apply)
        settings.otherSettings?.let(otherSettingsApplier::apply)
        settings.projectSettings?.let(projectSettingsSettingsApplier::apply)
        settings.tools?.let(toolsSettingsApplier::apply)
    }
}
