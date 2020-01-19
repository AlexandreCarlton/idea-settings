package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.IdeaSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.BuildExecutionDeploymentSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.BuildToolsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.AnnotationProcessorsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.NullableNotNullConfigurationSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.configurations.ConfigurationsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.EditorSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.CodeStyleSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaCodeStyleSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines.JavaBlankLinesSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript.JavascriptCodeStyleSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.GeneralSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.AutoImportSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.InspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling.SpellingSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.LanguagesFrameworksSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.OtherSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.ProjectSettingsSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project.ProjectSettingsApplier
import com.github.alexandrecarlton.idea.settings.applier.impl.tools.ToolsSettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.BuildExecutionDeploymentSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.build_tools.BuildToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.AnnotationProcessorsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NullableNotNullConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.EditorSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.CodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.JavaCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.java.blank_lines.JavaBlankLinesSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.codestyle.javascript.JavascriptCodeStyleSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.GeneralSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.general.auto_import.AutoImportSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.InspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.spelling.SpellingSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.LanguagesFrameworksSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsSettings
import com.github.alexandrecarlton.idea.settings.layout.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettings
import com.github.alexandrecarlton.idea.settings.layout.other_settings.OtherSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings
import com.github.alexandrecarlton.idea.settings.layout.tools.ToolsSettings
import dagger.Binds
import dagger.Module

@Module
interface SettingsApplierModule {

    @Binds
    fun bindAutoImportSettingsApplier(applier: AutoImportSettingsApplier): SettingsApplier<AutoImportSettings>

    @Binds
    fun bindAnnotationProcessorsSettingsApplier(applier: AnnotationProcessorsSettingsApplier): SettingsApplier<AnnotationProcessorsSettings>

    @Binds
    fun bindBuildExecutionDeploymentSettingsApplier(applier: BuildExecutionDeploymentSettingsApplier): SettingsApplier<BuildExecutionDeploymentSettings>

    @Binds
    fun bindBuildToolsSettingsApplier(applier: BuildToolsSettingsApplier): SettingsApplier<BuildToolsSettings>

    @Binds
    fun bindCodeStyleSettingsApplier(applier: CodeStyleSettingsApplier): SettingsApplier<CodeStyleSettings>

    @Binds
    fun bindConfigurationsSettingsApplier(applier: ConfigurationsSettingsApplier): SettingsApplier<ConfigurationSettings>

    @Binds
    fun bindEditorSettingsApplier(applier: EditorSettingsApplier): SettingsApplier<EditorSettings>

    @Binds
    fun bindEslintSettingsApplier(applier: EslintSettingsApplier): SettingsApplier<EslintSettings>

    @Binds
    fun bindGeneralSettingsApplier(applier: GeneralSettingsApplier): SettingsApplier<GeneralSettings>

    @Binds
    fun bindIdeaSettingsApplier(applier: IdeaSettingsApplier): SettingsApplier<IdeaSettings>

    @Binds
    fun bindInspectionsSettingsApplier(applier: InspectionsSettingsApplier): SettingsApplier<InspectionsSettings>

    @Binds
    fun bindJavaCodeStyleIssuesInspectionsSettingsApplier(applier: JavaCodeStyleIssuesInspectionsSettingsApplier): SettingsApplier<JavaCodeStyleIssuesInspectionsSettings>

    @Binds
    fun bindJavaCodeStyleSettingsApplier(applier: JavaCodeStyleSettingsApplier): SettingsApplier<JavaCodeStyleSettings>

    @Binds
    fun bindJavaBlankLinesSettingsApplier(applier: JavaBlankLinesSettingsApplier): SettingsApplier<JavaBlankLinesSettings>

    @Binds
    fun bindJavascriptCodeStyleSettingsApplier(applier: JavascriptCodeStyleSettingsApplier): SettingsApplier<JavascriptCodeStyleSettings>

    @Binds
    fun bindJavascriptCodeQualityToolsInspectionsSettingsApplier(applier: JavascriptCodeQualityToolsInspectionsSettingsApplier): SettingsApplier<JavascriptCodeQualityToolsInspectionsSettings>

    @Binds
    fun bindJavascriptCodeQualityToolsSettingsApplier(applier: JavascriptCodeQualityToolsSettingsApplier): SettingsApplier<JavascriptCodeQualityToolsSettings>

    @Binds
    fun bindLanguagesFrameworksSettingsApplier(applier: LanguagesFrameworksSettingsApplier): SettingsApplier<LanguagesFrameworksSettings>

    @Binds
    fun bindNullableNotNullConfigurationSettingsApplier(applier: NullableNotNullConfigurationSettingsApplier): SettingsApplier<NullableNotNullConfigurationSettings>

    @Binds
    fun bindOtherSettingsApplier(applier: OtherSettingsApplier): SettingsApplier<OtherSettings>

    @Binds
    fun bindProjectSettingsApplier(applier: ProjectSettingsApplier): SettingsApplier<ProjectSettings>

    @Binds
    fun bindProjectSettingsSettingsApplier(applier: ProjectSettingsSettingsApplier): SettingsApplier<ProjectSettingsSettings>

    @Binds
    fun bindSpellingSettingsApplier(applier: SpellingSettingsApplier): SettingsApplier<SpellingSettings>

    @Binds
    fun bindToolsSettingsApplier(applier: ToolsSettingsApplier): SettingsApplier<ToolsSettings>

}
