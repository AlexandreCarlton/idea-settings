package com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import dagger.Binds
import dagger.Module

@Module(includes = [JavaAutoImportModule::class])
interface AutoImportModule {

    @Binds
    fun providesAutoImportSettingsApplier(applier: AutoImportSettingsApplier): SettingsApplier<AutoImportSettings>
}
