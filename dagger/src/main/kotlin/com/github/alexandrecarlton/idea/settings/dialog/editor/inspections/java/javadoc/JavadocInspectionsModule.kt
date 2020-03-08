package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object JavadocInspectionsModule : AbstractPluginModule() {

    @Provides
    fun provideJavadocInspectionsSettingsApplier(applier: Lazy<JavadocInspectionsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideMissingDeprecatedAnnotationInspectionSettingsApplier(applier: Lazy<MissingDeprecatedAnnotationInspectionSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
