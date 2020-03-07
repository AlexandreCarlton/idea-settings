package com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface LanguagesFrameworksModule {

    @Binds
    fun bindLanguagesFrameworksSettingsApplier(applier: LanguagesFrameworksSettingsApplier): SettingsApplier<LanguagesFrameworksSettings>
}
