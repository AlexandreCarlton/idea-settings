package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.dagger.configuration.ConfigurationSubcomponent
import com.github.alexandrecarlton.idea.settings.dagger.inspections.InspectionsSubcomponent
import com.github.alexandrecarlton.idea.settings.dagger.module.ModuleSubcomponent
import com.intellij.application.options.CodeStyle
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings
import com.intellij.codeInspection.ex.InspectionProfileImpl
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.execution.RunManager
import com.intellij.execution.impl.RunConfigurationBeforeRunProvider
import com.intellij.externalDependencies.ExternalDependenciesManager
import com.intellij.ide.impl.ProjectUtil
import com.intellij.lang.java.JavaLanguage
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings
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
    InspectionsSubcomponent::class])
object ProjectModule {

    @Provides
    internal fun provideProject(@Named("project") path: String): Project =
        ProjectUtil.openOrImport(path, null, false)!!

    @Provides
    internal fun provideProjectEx(project: Project): ProjectEx = project as ProjectEx

    @Provides
    internal fun provideCodeInsightWorkspaceSettings(project: Project) = CodeInsightWorkspaceSettings.getInstance(project)

    @Provides
    internal fun provideCodeStyleSettings(codeStyleSettingsManager: CodeStyleSettingsManager, project: Project): CodeStyleSettings {
        // Ensure we only distribute one codeStyleSettings that is mutated in our appliers.
        codeStyleSettingsManager.USE_PER_PROJECT_SETTINGS = true
        codeStyleSettingsManager.mainProjectCodeStyle = CodeStyle.getDefaultSettings()
        return CodeStyle.getSettings(project)
    }

    @Provides
    internal fun provideCodeStyleSettingsManager(project: Project) = CodeStyleSettingsManager.getInstance(project)

    @Provides
    @Named("java")
    internal fun provideCommonCodeStyleSettings(codeStyleSettings: CodeStyleSettings) =
        codeStyleSettings.getCommonSettings(JavaLanguage.INSTANCE)

    @Provides
    internal fun provideCompilerConfiguration(project: Project) = CompilerConfiguration.getInstance(project)

    @Provides
    internal fun provideCompilerWorkspaceConfiguration(project: Project) = CompilerWorkspaceConfiguration.getInstance(project)

    @Provides
    internal fun provideDockerRunConfigurationCreator(project: Project) = DockerRunConfigurationCreator(project)

    @Provides
    internal fun provideExternalDependenciesManager(project: Project) = ExternalDependenciesManager.getInstance(project)

    @Provides
    internal fun provideInspectionProfileImpl(projectInspectionProfileManager: ProjectInspectionProfileManager): InspectionProfileImpl {
        val profile = projectInspectionProfileManager.getProfile("Project Default")
        profile.isProjectLevel = true
        return profile
    }

    @Provides
    internal fun provideJavaCodeStyleSettings(codeStyleSettings: CodeStyleSettings): JavaCodeStyleSettings =
        codeStyleSettings.getCustomSettings(JavaCodeStyleSettings::class.java)

    @Provides
    internal fun provideJavaProjectCodeInsightSettings(project: Project) = JavaProjectCodeInsightSettings.getSettings(project)

    @Provides
    internal fun provideJSRootConfiguration(project: Project) = JSRootConfiguration.getInstance(project)

    @Provides
    internal fun provideJSCodeStyleSettings(codeStyleSettings: CodeStyleSettings): JSCodeStyleSettings =
        codeStyleSettings.getCustomSettings(JSCodeStyleSettings::class.java)

    @Provides
    internal fun provideLanguageLevelProjectExtension(project: Project) = LanguageLevelProjectExtension.getInstance(project)

    @Provides
    internal fun provideMavenGeneralSettings(mavenProjectsManager: MavenProjectsManager) = mavenProjectsManager.generalSettings

    @Provides
    internal fun provideMavenImportingSettings(mavenProjectsManager: MavenProjectsManager) = mavenProjectsManager.importingSettings

    @Provides
    internal fun provideMavenProjectsManager(project: Project) = MavenProjectsManager.getInstance(project)

    @Provides
    internal fun provideModuleManager(project: Project) = ModuleManager.getInstance(project)

    @Provides
    internal fun providePluginConfigurationManager(project: Project) = PluginConfigurationManager.getInstance(project)

    @Provides
    internal fun provideProjectInspectionProfileManager(project: Project) = ProjectInspectionProfileManager.getInstance(project)

    @Provides
    internal fun provideProjectRootManager(project: Project) = ProjectRootManager.getInstance(project)

    @Provides
    internal fun provideProjectTasksOptions(project: Project) = ProjectTasksOptions.getInstance(project)

    @Provides
    internal fun provideRunConfigurationBeforeRunProvider(project: Project) = RunConfigurationBeforeRunProvider(project)

    @Provides
    internal fun provideSqlDialectMappings(project: Project) = SqlDialectMappings.getInstance(project)

    @Provides
    internal fun provideRunManager(project: Project) = RunManager.getInstance(project)

    @Provides
    internal fun provideSpellCheckerSettings(project: Project) = SpellCheckerSettings.getInstance(project)
}
