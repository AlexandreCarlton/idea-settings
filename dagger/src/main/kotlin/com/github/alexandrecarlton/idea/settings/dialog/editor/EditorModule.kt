package com.github.alexandrecarlton.idea.settings.dialog.editor

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface EditorModule {
    @Binds
    fun bindEditorSettingsApplier(applier: EditorSettingsApplier): SettingsApplier<EditorSettings>
}
