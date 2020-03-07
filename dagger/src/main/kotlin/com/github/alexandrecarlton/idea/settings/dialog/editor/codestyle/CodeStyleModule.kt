package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface CodeStyleModule {
    @Binds
    fun bindCodeStyleSettingsApplier(applier: CodeStyleSettingsApplier): SettingsApplier<CodeStyleSettings>
}
