package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavaProbableBugsInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideJavaProbableBugsInspectionsSettingsApplier(applier: Lazy<JavaProbableBugsInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier(applier: Lazy<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
