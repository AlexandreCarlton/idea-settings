package com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.InstrumentedAnnotation
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NotnullAnnotationsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NullableAnnotationsSettings
import com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment.compiler.NullableNotNullConfigurationSettings
import com.intellij.codeInsight.NullableNotNullManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class NullableNotNullConfigurationSettingsApplierTest: IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<NullableNotNullConfigurationSettings>
    private lateinit var nullableNotNullManager: NullableNotNullManager

    @Before
    public override fun setUp() {
        nullableNotNullManager = NullableNotNullManager.getInstance(project)
        settingsApplier = NullableNotNullConfigurationSettingsApplier(nullableNotNullManager)
    }

    @Test
    fun nullableAnnotationUsedForCodeGeneration() {
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            nullableAnnotations = NullableAnnotationsSettings(
                annotationUsedForCodeGeneration = "javax.annotation.Nullable")))
        assertThat(nullableNotNullManager.defaultNullable).isEqualTo("javax.annotation.Nullable")
    }

    @Test
    fun nullableAnnotations() {
        val nullableAnnotations = listOf("javax.annotation.Nullable", "fake.annotation.Nullable")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            nullableAnnotations = NullableAnnotationsSettings(
                annotations = nullableAnnotations)))
        assertThat(nullableNotNullManager.nullables).containsAll(nullableAnnotations)
    }

    @Test
    fun nonnullAnnotationUsedForCodeGeneration() {
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotationUsedForCodeGeneration = "javax.annotation.Nonnull")))
        assertThat(nullableNotNullManager.defaultNotNull).isEqualTo("javax.annotation.Nonnull")
    }

    @Test
    fun nonnullAnnotations() {
        val nonnullAnnotations = listOf("javax.annotation.Nonnull", "fake.annotation.Nonnull")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotations = nonnullAnnotations.map { InstrumentedAnnotation(annotation = it, instrumented = false) })))
        assertThat(nullableNotNullManager.notNulls).containsAll(nonnullAnnotations)
        assertThat(nullableNotNullManager.instrumentedNotNulls).isEmpty()
    }

    @Test
    fun nonnullInstrumentedAnnotations() {
        val instrumentedAnnotations = listOf("javax.annotation.Nonnull", "fake.annotation.Nonnull")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotations = instrumentedAnnotations.map { InstrumentedAnnotation(annotation = it, instrumented = true) })))
        assertThat(nullableNotNullManager.instrumentedNotNulls).containsAll(instrumentedAnnotations)
    }

}
