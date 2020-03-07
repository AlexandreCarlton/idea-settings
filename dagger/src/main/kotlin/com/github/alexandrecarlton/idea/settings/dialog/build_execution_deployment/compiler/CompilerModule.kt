package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.common.AbstractPluginModule
import com.github.alexandrecarlton.idea.settings.common.Plugin
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
object CompilerModule : AbstractPluginModule() {
    @Provides
    fun provideCompilerSettingsApplier(applier: Lazy<CompilerSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideNullableNotNullConfigurationSettingsApplier(applier: Lazy<NullableNotNullConfigurationSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)

    @Provides
    fun provideAnnotationProcessorsSettingsApplier(applier: Lazy<AnnotationProcessorsSettingsApplier>) =
        provideIfLoaded(Plugin.JAVA, applier)
}
