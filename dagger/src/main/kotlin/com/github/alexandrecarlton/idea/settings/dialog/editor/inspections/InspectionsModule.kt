package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface InspectionsModule {

    @Binds
    fun provideInspectionsSettingsApplier(applier: InspectionsSettingsApplier): SettingsApplier<InspectionsSettings>
}
