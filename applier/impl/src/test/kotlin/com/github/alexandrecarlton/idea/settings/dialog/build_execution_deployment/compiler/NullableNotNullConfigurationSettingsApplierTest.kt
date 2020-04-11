package com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class NullableNotNullConfigurationSettingsApplierTest: IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<NullableNotNullConfigurationSettings>

    @Before
    public override fun setUp() {
        settingsApplier = NullableNotNullConfigurationSettingsApplier(platform.nullableNotNullManager)
    }

    @Test
    fun nullableAnnotationUsedForCodeGeneration() {
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            nullableAnnotations = NullableAnnotationsSettings(
                annotationUsedForCodeGeneration = "javax.annotation.Nullable")))
        assertThat(platform.nullableNotNullManager.defaultNullable).isEqualTo("javax.annotation.Nullable")
    }

    @Test
    fun nullableAnnotations() {
        val nullableAnnotations = listOf("javax.annotation.Nullable", "fake.annotation.Nullable")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            nullableAnnotations = NullableAnnotationsSettings(
                annotations = nullableAnnotations)))
        assertThat(platform.nullableNotNullManager.nullables).containsAll(nullableAnnotations)
    }

    @Test
    fun nonnullAnnotationUsedForCodeGeneration() {
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotationUsedForCodeGeneration = "javax.annotation.Nonnull")))
        assertThat(platform.nullableNotNullManager.defaultNotNull).isEqualTo("javax.annotation.Nonnull")
    }

    @Test
    fun nonnullAnnotations() {
        val nonnullAnnotations = listOf("javax.annotation.Nonnull", "fake.annotation.Nonnull")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotations = nonnullAnnotations.map { InstrumentedAnnotation(annotation = it, instrumented = false) })))
        assertThat(platform.nullableNotNullManager.notNulls).containsAll(nonnullAnnotations)
        assertThat(platform.nullableNotNullManager.instrumentedNotNulls).isEmpty()
    }

    @Test
    fun nonnullInstrumentedAnnotations() {
        val instrumentedAnnotations = listOf("javax.annotation.Nonnull", "fake.annotation.Nonnull")
        settingsApplier.apply(NullableNotNullConfigurationSettings(
            notnullAnnotations = NotnullAnnotationsSettings(
                annotations = instrumentedAnnotations.map { InstrumentedAnnotation(annotation = it, instrumented = true) })))
        assertThat(platform.nullableNotNullManager.instrumentedNotNulls).containsAll(instrumentedAnnotations)
    }

}
