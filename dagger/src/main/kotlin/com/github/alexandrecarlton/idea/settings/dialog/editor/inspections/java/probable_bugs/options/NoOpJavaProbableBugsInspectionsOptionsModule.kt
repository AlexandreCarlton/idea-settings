package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.noop.NoOpSettingsApplier
import dagger.Binds
import dagger.Module

@Module
interface NoOpJavaProbableBugsInspectionsOptionsModule {
    @Binds
    fun bindArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettingsApplier(applier: NoOpSettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>): SettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>
}
