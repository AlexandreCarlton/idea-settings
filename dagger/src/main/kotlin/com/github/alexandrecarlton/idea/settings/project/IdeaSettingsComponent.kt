package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.dialog.IdeaModule
import com.github.alexandrecarlton.idea.settings.dialog.IdeaSettings
import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.BuildExecutionDeploymentModule
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.BuildToolsModule
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenModule
import com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.CompilerModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.ConfigurationsModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.application.ApplicationModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.remote.RemoteModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.shell_script.ShellScriptModule
import com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.EditorModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.CodeStyleModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.JavaCodeStyleModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement.JavaArrangementModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.blank_lines.JavaBlankLinesModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.imports.JavaImportsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.javadoc.JavadocModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript.JavascriptCodeStyleModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.general.GeneralModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.AutoImportModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.InspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.JavaInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.JavaCodeStyleIssuesInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.JavadocInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.JavaProbableBugsInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.JavascriptInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.JavascriptCodeQualityToolsInspectionsModule
import com.github.alexandrecarlton.idea.settings.dialog.editor.spelling.SpellingModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.LanguagesFrameworksModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.JavascriptLanguagesFrameworksModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.JavascriptCodeQualityToolsModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint.EslintModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm.NodejsAndNpmModule
import com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialectsModule
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.OtherSettingsModule
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle.CheckstyleModule
import com.github.alexandrecarlton.idea.settings.dialog.other_settings.save_actions.SaveActionsModule
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.ProjectSettingsModule
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules.ProjectSettingsModulesModule
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.project.ProjectSettingsProjectModule
import com.github.alexandrecarlton.idea.settings.dialog.tools.ToolsModule
import com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers.FileWatchersModule
import com.intellij.openapi.project.Project
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [
    ApplicationModule::class,
    AutoImportModule::class,
    BuildExecutionDeploymentModule::class,
    BuildToolsModule::class,
    CheckstyleModule::class,
    CodeStyleModule::class,
    CompilerModule::class,
    ConfigurationsModule::class,
    DockerModule::class,
    EditorModule::class,
    EslintModule::class,
    FileWatchersModule::class,
    GeneralModule::class,
    IdeaModule::class,
    JavaArrangementModule::class,
    JavaBlankLinesModule::class,
    JavaCodeStyleModule::class,
    JavadocModule::class,
    JavaImportsModule::class,
    JavascriptCodeQualityToolsModule::class,
    JavascriptCodeStyleModule::class,
    JavascriptLanguagesFrameworksModule::class,
    JavaWrappingAndBracesModule::class,
    LanguagesFrameworksModule::class,
    MavenModule::class,
    OtherSettingsModule::class,
    NodejsAndNpmModule::class,
    ProjectSettingsModule::class,
    ProjectSettingsModulesModule::class,
    ProjectSettingsProjectModule::class,
    RemoteModule::class,
    SaveActionsModule::class,
    ShellScriptModule::class,
    SpellingModule::class,
    SpringBootModule::class,
    SqlDialectsModule::class,
    ToolsModule::class,
    InspectionsModule::class,
    ConfigurationTypeModule::class,
    IdeaSingletonModule::class,
    JavaCodeStyleIssuesInspectionsModule::class,
    JavadocInspectionsModule::class,
    JavaInspectionsModule::class,
    JavaProbableBugsInspectionsModule::class,
    JavascriptCodeQualityToolsInspectionsModule::class,
    JavascriptInspectionsModule::class,
    FileTypeModule::class,
    ProjectModule::class,
    ToolsImplModule::class])
interface IdeaSettingsComponent {

    fun applier(): SettingsApplier<IdeaSettings>

    fun project(): Project

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun project(@Named("project") project: String): Builder

        fun build(): IdeaSettingsComponent
    }
}
