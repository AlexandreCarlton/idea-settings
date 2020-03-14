package com.github.alexandrecarlton.idea.settings.dialog.configurations.npm

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.NpmConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.ACCESS
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.ADD
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.ADDUSER
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.AUDIT
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.BIN
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.BUGS
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.BUILD
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.CACHE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.CI
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.COMPLETION
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.CONFIG
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.DEDUPE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.DEPRECATE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.DIST_TAG
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.DOCS
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.EDIT
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.EXPLORE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.HELP
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.HELP_SEARCH
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.INFO
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.INIT
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.INSTALL
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.LINK
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.LOGOUT
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.LS
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.NPM
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.OUTDATED
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.OWNER
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.PACK
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.PING
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.PREFIX
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.PRUNE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.PUBLISH
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.REBUILD
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.REPO
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.RESTART
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.ROOT
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.RUN
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.SEARCH
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.SHRINKWRAP
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.STAR
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.STARS
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.START
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.STOP
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.TAG
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.TEAM
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.TEST
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.UNINSTALL
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.UNPUBLISH
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.UPDATE
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.VERSION
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.VIEW
import com.github.alexandrecarlton.idea.settings.dialog.configurations.npm.NpmConfigurationCommand.WHOAMI
import com.intellij.execution.RunManager
import com.intellij.execution.configuration.EnvironmentVariablesData
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterRef
import com.intellij.javascript.nodejs.util.NodePackageRef
import com.intellij.lang.javascript.buildTools.npm.rc.NpmCommand
import com.intellij.lang.javascript.buildTools.npm.rc.NpmConfigurationType
import com.intellij.lang.javascript.buildTools.npm.rc.NpmRunConfiguration
import com.intellij.lang.javascript.buildTools.npm.rc.NpmRunSettings
import com.intellij.openapi.project.Project
import javax.inject.Inject

class NpmConfigurationSettingsApplier @Inject constructor(
    private val project: Project,
    private val runManager: RunManager
) : SettingsApplier<NpmConfigurationSettings> {
    override fun apply(settings: NpmConfigurationSettings) {
        val npmRunSettingsBuilder = NpmRunSettings.builder()

        settings.packageJson?.toString()?.let(npmRunSettingsBuilder::setPackageJsonPath)
        settings.command?.let(::toNpmCommand)?.let(npmRunSettingsBuilder::setCommand)
        // For some reason this takes in a list, despite only allowing one script to be used.
        settings.scripts?.let { listOf(it) }?.let(npmRunSettingsBuilder::setScriptNames)
        settings.arguments?.let { npmRunSettingsBuilder.setArguments(it) }

        settings.nodeInterpreter?.toString()?.let(NodeJsInterpreterRef::create)?.let(npmRunSettingsBuilder::setInterpreterRef)
        settings.nodeOptions?.let(npmRunSettingsBuilder::setNodeOptions)
        settings.packageManager?.toString()?.let(NodePackageRef::create)?.let(npmRunSettingsBuilder::setPackageManagerPackageRef)

        settings.environment
            ?.let { e -> e.associateBy({ it.name }, { it.value }) }
            ?.let { EnvironmentVariablesData.create(it, true) }
            ?.let(npmRunSettingsBuilder::setEnvData)

        val npmRunConfiguration = NpmRunConfiguration(project, NpmConfigurationType.getInstance(), settings.name)
        npmRunConfiguration.runSettings = npmRunSettingsBuilder.build()

        val runnerAndConfigurationSettings = runManager.createConfiguration(npmRunConfiguration, NpmConfigurationType.getInstance())
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun toNpmCommand(command: NpmConfigurationCommand) =
        when(command) {
            ACCESS -> NpmCommand.ACCESS
            ADD -> NpmCommand.ADD
            ADDUSER -> NpmCommand.ADD_USER
            AUDIT -> NpmCommand.AUDIT
            BIN -> NpmCommand.BIN
            BUGS -> NpmCommand.BUGS
            BUILD -> NpmCommand.BUILD
            CACHE -> NpmCommand.CACHE
            CI -> NpmCommand.CI
            COMPLETION -> NpmCommand.COMPLETION
            CONFIG -> NpmCommand.CONFIG
            DEDUPE -> NpmCommand.DEDUPE
            DEPRECATE -> NpmCommand.DEPRECATE
            DIST_TAG -> NpmCommand.DIST_TAG
            DOCS -> NpmCommand.DOCS
            EDIT -> NpmCommand.EDIT
            EXPLORE -> NpmCommand.EXPLORE
            HELP -> NpmCommand.HELP
            HELP_SEARCH -> NpmCommand.HELP_SEARCH
            INIT -> NpmCommand.INIT
            INSTALL -> NpmCommand.INSTALL
            INFO -> NpmCommand.INFO
            LINK -> NpmCommand.LINK
            LOGOUT -> NpmCommand.LOGOUT
            LS -> NpmCommand.LS
            NPM -> NpmCommand.NPM
            OUTDATED -> NpmCommand.OUTDATED
            OWNER -> NpmCommand.OWNER
            PACK -> NpmCommand.PACK
            PING -> NpmCommand.PING
            PREFIX -> NpmCommand.PREFIX
            PRUNE -> NpmCommand.PRUNE
            PUBLISH -> NpmCommand.PUBLISH
            REBUILD -> NpmCommand.REBUILD
            REPO -> NpmCommand.REPO
            RESTART -> NpmCommand.RESTART
            ROOT -> NpmCommand.ROOT
            RUN -> NpmCommand.RUN_SCRIPT
            SEARCH -> NpmCommand.SEARCH
            SHRINKWRAP -> NpmCommand.SHRINKWRAP
            STAR -> NpmCommand.STAR
            STARS -> NpmCommand.STARS
            START -> NpmCommand.START
            STOP -> NpmCommand.STOP
            TAG -> NpmCommand.TAG
            TEAM -> NpmCommand.TEAM
            TEST -> NpmCommand.TEST
            UNINSTALL -> NpmCommand.UNINSTALL
            UNPUBLISH -> NpmCommand.UNPUBLISH
            UPDATE -> NpmCommand.UPDATE
            VERSION -> NpmCommand.VERSION
            VIEW -> NpmCommand.VIEW
            WHOAMI -> NpmCommand.WHOAMI
        }
}
