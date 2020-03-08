package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface InspectionOptionsModule {
    @Binds
    fun provideInspectionOptionsSettingsApplier(applier: InspectionOptionsSettingsApplier): SettingsApplier<Any>
}

