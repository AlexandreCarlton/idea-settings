package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.intellij.openapi.module.Module

import dagger.BindsInstance
import dagger.Subcomponent

/**
 * A [Subcomponent] that provides objects for a particular [Module] of a project.
 */
@Subcomponent(modules = [ModuleModule::class, ProjectSettingsModulesModule::class])
interface ModuleSubcomponent {

    fun settingsApplier(): SettingsApplier<ModuleSettings>

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun module(module: Module): Builder

        fun build(): ModuleSubcomponent
    }
}
