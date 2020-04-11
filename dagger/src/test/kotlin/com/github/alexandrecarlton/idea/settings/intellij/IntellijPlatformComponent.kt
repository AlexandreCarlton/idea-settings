package com.github.alexandrecarlton.idea.settings.intellij

import com.dubreuia.model.Storage
import com.intellij.codeInsight.CodeInsightWorkspaceSettings
import com.intellij.codeInsight.JavaProjectCodeInsightSettings
import com.intellij.codeInsight.NullableNotNullManager
import com.intellij.compiler.CompilerConfiguration
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.execution.RunManager
import com.intellij.externalDependencies.ExternalDependenciesManager
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.lang.javascript.formatter.JSCodeStyleSettings
import com.intellij.lang.javascript.linter.eslint.EslintConfiguration
import com.intellij.lang.javascript.settings.JSRootConfiguration
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.plugins.watcher.model.ProjectTasksOptions
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.codeStyle.JavaCodeStyleSettings
import com.intellij.spellchecker.SpellCheckerManager
import com.intellij.spellchecker.settings.SpellCheckerSettings
import com.intellij.sql.dialects.SqlDialectMappings
import dagger.BindsInstance
import dagger.Component
import org.infernus.idea.checkstyle.config.PluginConfigurationManager
import org.jetbrains.idea.maven.project.MavenGeneralSettings
import org.jetbrains.idea.maven.project.MavenImportingSettings
import org.jetbrains.kotlin.idea.codeInsight.KotlinCodeInsightWorkspaceSettings
import org.jetbrains.kotlin.idea.core.formatter.KotlinCodeStyleSettings
import org.sonarlint.intellij.config.project.SonarLintProjectSettings
import javax.inject.Named

/**
 * A component to be used in tests to provide easy access to [Project]-specific classes.
 * This way we only need to define the retrieval of such instances once.
 *
 * We add accessors as necessary to this class.
 */
@Component(modules = [IntelliJPlatformModule::class])
interface IntellijPlatformComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance project: Project): IntellijPlatformComponent
    }

    val codeInsightWorkspaceSettings: CodeInsightWorkspaceSettings

    val codeStyleSettings: CodeStyleSettings

    val compilerConfiguration: CompilerConfiguration

    val compilerWorkspaceConfiguration: CompilerWorkspaceConfiguration

    val dockerRunConfigurationCreator: DockerRunConfigurationCreator

    val eslintConfiguration: EslintConfiguration

    val externalDependenciesManager: ExternalDependenciesManager

    val javaProjectCodeInsightSettings: JavaProjectCodeInsightSettings

    @get:Named("java")
    val javaCommonCodeStyleSettings: CommonCodeStyleSettings

    val javaCodeStyleSettings: JavaCodeStyleSettings

    val jsCodeStyleSettings: JSCodeStyleSettings

    val jsRootConfiguration: JSRootConfiguration

    val kotlinCodeInsightWorkspaceSettings: KotlinCodeInsightWorkspaceSettings

    val kotlinCodeStyleSettings: KotlinCodeStyleSettings

    @get:Named("Kotlin")
    val kotlinCommonCodeStyleSettings: CommonCodeStyleSettings

    val languageLevelProjectExtension: LanguageLevelProjectExtension

    val mavenGeneralSettings: MavenGeneralSettings

    val mavenImportingSettings: MavenImportingSettings

    val npmManager: NpmManager

    val nodeJsInterpreterManager: NodeJsInterpreterManager

    val nullableNotNullManager: NullableNotNullManager

    val pluginConfigurationManager: PluginConfigurationManager

    val projectRootManager: ProjectRootManager

    val projectTasksOptions: ProjectTasksOptions

    val runManager: RunManager

    val saveActionsStorage: Storage

    val sonarLintProjectSettings: SonarLintProjectSettings

    val spellCheckerManager: SpellCheckerManager

    val spellCheckerSettings: SpellCheckerSettings

    val sqlDialectMappings: SqlDialectMappings
}
