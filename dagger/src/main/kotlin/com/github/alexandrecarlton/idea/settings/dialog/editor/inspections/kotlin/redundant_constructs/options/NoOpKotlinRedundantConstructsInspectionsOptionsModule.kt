package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.noop.NoOpSettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface NoOpKotlinRedundantConstructsInspectionsOptionsModule {
    @Binds
    fun bindRedundantSemicolonInspectionOptionsSettingsApplier(applier: NoOpSettingsApplier<RedundantSemicolonInspectionOptionsSettings>): SettingsApplier<RedundantSemicolonInspectionOptionsSettings>

    @Binds
    fun bindUnusedImportDirectiveInspectionOptionsSettingsApplier(applier: NoOpSettingsApplier<UnusedImportDirectiveInspectionOptionsSettings>): SettingsApplier<UnusedImportDirectiveInspectionOptionsSettings>
}
