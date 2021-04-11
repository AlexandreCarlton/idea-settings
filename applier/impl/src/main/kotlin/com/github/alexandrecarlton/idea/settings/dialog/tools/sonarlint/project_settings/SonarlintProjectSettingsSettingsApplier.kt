package com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.openapi.project.Project
import org.sonarlint.intellij.config.project.ExclusionItem
import org.sonarlint.intellij.config.project.SonarLintProjectSettings
import java.io.File
import javax.inject.Inject

class SonarlintProjectSettingsSettingsApplier @Inject constructor(
    private val project: Project,
    private val sonarLintProjectSettings: SonarLintProjectSettings
) : SettingsApplier<SonarlintProjectSettingsSettings> {
    override fun apply(settings: SonarlintProjectSettingsSettings) {
        settings.bindToToSonarQubeSonarCloud?.bindProjectToSonarqubeSonarCloud?.let { sonarLintProjectSettings.isBindingEnabled = it }
        settings.bindToToSonarQubeSonarCloud?.projectBinding?.connection?.let { sonarLintProjectSettings.connectionName = it }
        settings.bindToToSonarQubeSonarCloud?.projectBinding?.project?.let { sonarLintProjectSettings.projectKey = it }

        settings.fileExclusions
            ?.map {
                when(it) {
                    is ExcludeFile -> ExclusionItem(ExclusionItem.Type.FILE, it.file.toRelativeString(File(project.basePath)))
                    is ExcludeDirectory -> ExclusionItem(ExclusionItem.Type.DIRECTORY, it.directory.toRelativeString(File(project.basePath)))
                    is ExcludeUsingGlobPattern -> ExclusionItem(ExclusionItem.Type.GLOB, it.glob)
                }
            }
            ?.map { it.toStringWithType() }
            ?.let { sonarLintProjectSettings.fileExclusions = it }

        settings.analysisProperties?.let { properties ->
            sonarLintProjectSettings.additionalProperties = properties.associateBy({ it.propertyName }, { it.value })
        }
    }
}
