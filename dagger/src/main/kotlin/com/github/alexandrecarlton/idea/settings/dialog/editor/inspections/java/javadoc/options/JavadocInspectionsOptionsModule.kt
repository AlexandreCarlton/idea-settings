package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.options

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavadocInspectionsOptionsModule : AbstractPluginModule() {

    @Provides
    fun provideMissingDeprecatedAnnotationInspectionOptionsSettingsApplier(applier: Lazy<MissingDeprecatedAnnotationInspectionOptionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
