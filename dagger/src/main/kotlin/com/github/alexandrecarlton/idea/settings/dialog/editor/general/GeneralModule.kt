package com.github.alexandrecarlton.idea.settings.dialog.editor.general

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface GeneralModule {

    @Binds
    fun bindGeneralSettingsApplier(applier: GeneralSettingsApplier): SettingsApplier<GeneralSettings>
}
