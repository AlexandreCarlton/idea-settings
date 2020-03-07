package com.github.alexandrecarlton.idea.settings.dialog.editor.spelling

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface SpellingModule {

    @Binds
    fun bindSpellingSettingsApplier(applier: SpellingSettingsApplier): SettingsApplier<SpellingSettings>
}
