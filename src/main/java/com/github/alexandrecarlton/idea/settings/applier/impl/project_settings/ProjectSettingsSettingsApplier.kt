package com.github.alexandrecarlton.idea.settings.applier.impl.project_settings

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dagger.module.ModuleSubcomponent.Builder
import com.github.alexandrecarlton.idea.settings.layout.project_settings.ProjectSettingsSettings
import com.github.alexandrecarlton.idea.settings.layout.project_settings.project.ProjectSettings
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleTypeId
import com.intellij.openapi.project.Project
import java.nio.file.Paths
import javax.inject.Inject

class ProjectSettingsSettingsApplier @Inject
constructor(
    private val project: Project,
    private val moduleManager: ModuleManager,
    private val moduleSubcomponentBuilder: Builder,
    private val projectSettingsApplier: SettingsApplier<ProjectSettings>)
: SettingsApplier<ProjectSettingsSettings> {

    override fun apply(settings: ProjectSettingsSettings) {
        for (moduleSettings in settings.modules()) {
            var module = moduleManager.findModuleByName(moduleSettings.name())
            if (module == null) {
                val moduleFile = moduleSettings.sources()
                    .stream()
                    .findFirst()
                    .map { it.contentRoot() }
                    .orElse(Paths.get(project.basePath))
                    .resolve(moduleSettings.name() + ".iml")
                module = moduleManager.newModule(moduleFile.toString(), ModuleTypeId.JAVA_MODULE)
            }
            val moduleSubcomponent = moduleSubcomponentBuilder.module(module).build()
            moduleSubcomponent.settingsApplier().apply(moduleSettings)
        }
        settings.project().ifPresent { projectSettingsApplier.apply(it) }
    }
}
