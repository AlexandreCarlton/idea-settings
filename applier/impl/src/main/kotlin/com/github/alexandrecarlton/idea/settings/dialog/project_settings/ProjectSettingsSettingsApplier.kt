package com.github.alexandrecarlton.idea.settings.dialog.project_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings
import com.github.alexandrecarlton.idea.settings.module.ModuleSubcomponent.Builder
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleTypeId
import com.intellij.openapi.project.Project
import java.io.File
import javax.inject.Inject

class ProjectSettingsSettingsApplier @Inject
constructor(
    private val project: Project,
    private val moduleManager: ModuleManager,
    private val moduleSubcomponentBuilder: Builder,
    private val projectSettingsApplier: SettingsApplier<ProjectSettings>)
: SettingsApplier<ProjectSettingsSettings> {

    override fun apply(settings: ProjectSettingsSettings) {
        for (moduleSettings in settings.modules ?: emptyList()) {
            var module = moduleManager.findModuleByName(moduleSettings.name)
            if (module == null) {
                val moduleFile = (moduleSettings.sources?.firstOrNull()?.contentRoot ?: File(project.basePath))
                    .resolve("${moduleSettings.name}.iml")
                module = moduleManager.newModule(moduleFile.toString(), ModuleTypeId.JAVA_MODULE)
            }
            val moduleSubcomponent = moduleSubcomponentBuilder.module(module).build()
            moduleSubcomponent.settingsApplier().apply(moduleSettings)
        }
        settings.project?.let(projectSettingsApplier::apply)
    }
}
