package com.github.alexandrecarlton.idea.settings.dagger.project

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.IdeaSettings
import com.intellij.openapi.project.Project
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [
    SettingsApplierModule::class,
    ConfigurationTypeModule::class,
    IdeaModule::class,
    FileTypeModule::class,
    OptionalSettingsApplierModule::class,
    ProjectModule::class])
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
