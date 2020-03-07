package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NullableNotNullConfigurationSettings
import com.intellij.codeInsight.NullableNotNullManager
import javax.inject.Inject

class NullableNotNullConfigurationSettingsApplier @Inject
constructor(private val nullableNotNullManager: NullableNotNullManager)
: SettingsApplier<NullableNotNullConfigurationSettings> {
    override fun apply(settings: NullableNotNullConfigurationSettings) {

        settings.nullableAnnotations
            ?.annotationUsedForCodeGeneration
            ?.let { nullableNotNullManager.defaultNullable = it }

        settings.nullableAnnotations
            ?.annotations
            ?.let { nullableNotNullManager.setNullables(*it.toTypedArray()) }

        settings.notnullAnnotations
            ?.annotationUsedForCodeGeneration
            ?.let { nullableNotNullManager.defaultNotNull = it }

        settings.notnullAnnotations
            ?.annotations
            ?.map { it.annotation }
            ?.let { nullableNotNullManager.setNotNulls(*it.toTypedArray()) }

        settings.notnullAnnotations
            ?.annotations
            ?.filter { it.instrumented ?: false }
            ?.map { it.annotation }
            ?.let { nullableNotNullManager.instrumentedNotNulls = it }
    }
}
