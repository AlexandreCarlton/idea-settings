package com.github.alexandrecarlton.idea.settings.dialog.other_settings

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface OtherSettingsModule {

    @Binds
    fun provideOtherSettingsApplier(applier: OtherSettingsApplier): SettingsApplier<OtherSettings>
}
