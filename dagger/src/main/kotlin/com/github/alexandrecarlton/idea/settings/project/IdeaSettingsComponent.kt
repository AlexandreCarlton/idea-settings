package com.github.alexandrecarlton.idea.settings.project

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.IdeaSettings
import com.intellij.openapi.project.Project
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [
    SettingsApplierModule::class,
    ConfigurationTypeModule::class,
    IdeaModule::class,
    InspectionSettingsApplierModule::class,
    FileTypeModule::class,
    OptionalSettingsApplierModule::class,
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
