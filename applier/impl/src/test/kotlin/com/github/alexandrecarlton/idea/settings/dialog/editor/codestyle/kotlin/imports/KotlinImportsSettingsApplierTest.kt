package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.psi.codeStyle.PackageEntry
import com.intellij.psi.codeStyle.PackageEntryTable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class KotlinImportsSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<KotlinImportsSettings>

    @Before
    public override fun setUp() {
        settingsApplier = KotlinImportsSettingsApplier(platform.kotlinCodeStyleSettings)
    }

    @Test
    fun topLevelSymbols() {
        settingsApplier.apply(KotlinImportsSettings(
            topLevelSymbols = UseSingleNameImportSettings))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT).isEqualTo(Int.MAX_VALUE)

        settingsApplier.apply(KotlinImportsSettings(
            topLevelSymbols = UseImportWithWildcardSettings))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT).isEqualTo(1)

        settingsApplier.apply(KotlinImportsSettings(
            topLevelSymbols = UseImportWithWildcardWhenAtLeastNamesUsedSettings(10)))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT).isEqualTo(10)
    }

    @Test
    fun javaStaticsAndEnumMembers() {
        settingsApplier.apply(KotlinImportsSettings(
            javaStaticsAndEnumMembers = UseSingleNameImportSettings))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT_FOR_MEMBERS).isEqualTo(Int.MAX_VALUE)

        settingsApplier.apply(KotlinImportsSettings(
            javaStaticsAndEnumMembers = UseImportWithWildcardSettings))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT_FOR_MEMBERS).isEqualTo(1)

        settingsApplier.apply(KotlinImportsSettings(
            javaStaticsAndEnumMembers = UseImportWithWildcardWhenAtLeastNamesUsedSettings(10)))
        assertThat(platform.kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT_FOR_MEMBERS).isEqualTo(10)
    }

    @Test
    fun packagesToUseImportWithWildcard() {
        settingsApplier.apply(KotlinImportsSettings(
            packagesToUseImportWithWildcard = listOf(
                KotlinPackageToImportWithWildcard("java.util", true),
                KotlinPackageToImportWithWildcard("org.junit", false))))
        assertThat(platform.kotlinCodeStyleSettings.PACKAGES_TO_USE_STAR_IMPORTS).isEqualTo(PackageEntryTable().apply {
            addEntry(PackageEntry(false, "java.util", true))
            addEntry(PackageEntry(false, "org.junit", false))
        })
    }
}
