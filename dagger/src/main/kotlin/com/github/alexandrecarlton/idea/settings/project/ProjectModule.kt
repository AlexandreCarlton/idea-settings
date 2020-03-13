package com.github.alexandrecarlton.idea.settings.project

import com.dubreuia.model.StorageFactory
import com.github.alexandrecarlton.idea.settings.configuration.ConfigurationSubcomponent
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.subcomponent.InspectionsSubcomponent
import com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules.ModuleSubcomponent
import com.intellij.application.options.CodeStyle
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings
import com.intellij.codeInsight.NullableNotNullManager
import com.intellij.codeInspection.ex.InspectionProfileImpl
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.execution.RunManager
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider
import com.intellij.externalDependencies.ExternalDependenciesManager
import com.intellij.ide.impl.ProjectUtil
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.lang.java.JavaLanguage
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings
import com.intellij.lang.javascript.linter.eslint.EslintConfiguration
import com.intellij.lang.javascript.settings.JSRootConfiguration
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ex.ProjectEx
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import com.intellij.profile.codeInspection.ProjectInspectionProfileManager
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsManager
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import com.intellij.spellchecker.SpellCheckerManager
import com.intellij.spellchecker.settings.SpellCheckerSettings
import com.intellij.sql.dialects.SqlDialectMappings
import dagger.Module
import dagger.Provides
import org.infernus.idea.checkstyle.config.PluginConfigurationManager
import org.jetbrains.idea.maven.project.MavenProjectsManager
import javax.inject.Named

/**
 * Provides components that depend on the imported [Project].
 */
@Module(subcomponents = [
    ModuleSubcomponent::class,
    ConfigurationSubcomponent::class,
    // This should be attached to the Module that provides the class that uses this subcomponent.
    // This is the BaseInspectionSettingsApplier, so just chuck this on InspectionsModule.
    InspectionsSubcomponent::class])
object ProjectModule {

    @Provides
    fun provideProject(@Named("project") path: String): Project =
        ProjectUtil.openOrImport(path, null, false)!!

    @Provides
    fun provideProjectEx(project: Project): ProjectEx = project as ProjectEx

    @Provides
    fun provideCodeInsightWorkspaceSettings(project: Project) = CodeInsightWorkspaceSettings.getInstance(project)

    @Provides
    fun provideCodeStyleSettings(codeStyleSettingsManager: CodeStyleSettingsManager, project: Project): CodeStyleSettings {
        // Ensure we only distribute one codeStyleSettings that is mutated in our appliers.
        codeStyleSettingsManager.USE_PER_PROJECT_SETTINGS = true
        codeStyleSettingsManager.mainProjectCodeStyle = CodeStyle.getDefaultSettings()
        return CodeStyle.getSettings(project)
    }

    @Provides
    fun provideCodeStyleSettingsManager(project: Project) = CodeStyleSettingsManager.getInstance(project)

    @Provides
    @Named("java")
    fun provideCommonCodeStyleSettings(codeStyleSettings: CodeStyleSettings) =
        codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)

    @Provides
    fun provideCompilerConfiguration(project: Project) = CompilerConfiguration.getInstance(project)

    @Provides
    fun provideCompilerWorkspaceConfiguration(project: Project) = CompilerWorkspaceConfiguration.getInstance(project)

    @Provides
    fun provideDockerRunConfigurationCreator(project: Project) = DockerRunConfigurationCreator(project)

    @Provides
    fun provideEslintConfiguration(project: Project) = EslintConfiguration.getInstance(project)

    @Provides
    fun provideExternalDependenciesManager(project: Project) = ExternalDependenciesManager.getInstance(project)

    @Provides
    fun provideInspectionProfileImpl(projectInspectionProfileManager: ProjectInspectionProfileManager): InspectionProfileImpl {
        val profile = projectInspectionProfileManager.getProfile("Project Default")
        profile.isProjectLevel = true
        return profile
    }

    @Provides
    fun provideJavaCodeStyleSettings(codeStyleSettings: CodeStyleSettings): JavaCodeStyleSettings =
        codeStyleSettings.getCustomSettings(JavaCodeStyleSettings::class.java)

    @Provides
    fun provideJavaProjectCodeInsightSettings(project: Project) = JavaProjectCodeInsightSettings.getSettings(project)

    @Provides
    fun provideJSRootConfiguration(project: Project) = JSRootConfiguration.getInstance(project)

    @Provides
    fun provideJSCodeStyleSettings(codeStyleSettings: CodeStyleSettings): JSCodeStyleSettings =
        codeStyleSettings.getCustomSettings(JSCodeStyleSettings::class.java)

    @Provides
    fun provideLanguageLevelProjectExtension(project: Project) = LanguageLevelProjectExtension.getInstance(project)

    @Provides
    fun provideMavenGeneralSettings(mavenProjectsManager: MavenProjectsManager) = mavenProjectsManager.generalSettings

    @Provides
    fun provideMavenImportingSettings(mavenProjectsManager: MavenProjectsManager) = mavenProjectsManager.importingSettings

    @Provides
    fun provideMavenProjectsManager(project: Project) = MavenProjectsManager.getInstance(project)

    @Provides
    fun provideModuleManager(project: Project) = ModuleManager.getInstance(project)

    @Provides
    fun provideNpmManager(project: Project) = NpmManager.getInstance(project)

    @Provides
    fun provideNodeJsInterpreterManager(project: Project) = NodeJsInterpreterManager.getInstance(project)

    @Provides
    fun provideNullableNotNullManager(project: Project) = NullableNotNullManager.getInstance(project)

    @Provides
    fun providePluginConfigurationManager(project: Project) = PluginConfigurationManager.getInstance(project)

    @Provides
    fun provideProjectInspectionProfileManager(project: Project) = ProjectInspectionProfileManager.getInstance(project)

    @Provides
    fun provideProjectRootManager(project: Project) = ProjectRootManager.getInstance(project)

    @Provides
    fun provideProjectTasksOptions(project: Project) = ProjectTasksOptions.getInstance(project)

    @Provides
    fun provideRunConfigurationBeforeRunProvider(project: Project) = RunConfigurationBeforeRunProvider(project)

    @Provides
    fun provideSaveActionsStorage(project: Project) = StorageFactory.DEFAULT.getStorage(project)

    @Provides
    fun provideSqlDialectMappings(project: Project) = SqlDialectMappings.getInstance(project)

    @Provides
    fun provideRunManager(project: Project) = RunManager.getInstance(project)

    @Provides
    fun provideSpellCheckerManager(project: Project) = SpellCheckerManager.getInstance(project)

    @Provides
    fun provideSpellCheckerSettings(project: Project) = SpellCheckerSettings.getInstance(project)
}
