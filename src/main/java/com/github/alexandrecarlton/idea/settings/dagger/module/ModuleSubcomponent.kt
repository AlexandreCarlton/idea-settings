package com.github.alexandrecarlton.idea.settings.dagger.module

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.project_settings.modules.ModuleSettings
import com.intellij.openapi.module.Module

import dagger.BindsInstance
import dagger.Subcomponent

/**
 * A [Subcomponent] that provides objects for a particular [Module] of a project.
 */
@Subcomponent(modules = [ModuleModule::class, SettingsApplierModule::class])
interface ModuleSubcomponent {

    fun settingsApplier(): SettingsApplier<ModuleSettings>

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun module(module: Module): Builder

        fun build(): ModuleSubcomponent
    }
}
