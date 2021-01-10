package com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import org.jetbrains.kotlin.idea.core.formatter.KotlinCodeStyleSettings
import org.jetbrains.kotlin.idea.core.formatter.KotlinPackageEntry
import org.jetbrains.kotlin.idea.core.formatter.KotlinPackageEntryTable
import javax.inject.Inject

class KotlinImportsSettingsApplier @Inject
constructor(
    private val kotlinCodeStyleSettings: KotlinCodeStyleSettings
) : SettingsApplier<KotlinImportsSettings> {
    override fun apply(settings: KotlinImportsSettings) {
        settings.topLevelSymbols?.let(::toImportCount)?.let { kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT = it }
        settings.javaStaticsAndEnumMembers?.let(::toImportCount)?.let { kotlinCodeStyleSettings.NAME_COUNT_TO_USE_STAR_IMPORT_FOR_MEMBERS = it }

        settings.packagesToUseImportWithWildcard
            ?.map { KotlinPackageEntry(it.packageToImport ?: "", it.withSubpackages ?: true) }
            ?.let {
                kotlinCodeStyleSettings.PACKAGES_TO_USE_STAR_IMPORTS.copyFrom(KotlinPackageEntryTable().apply {
                    it.forEach(::addEntry)
                })
            }
    }

    private fun toImportCount(settings: KotlinImportWithWildcardSettings) =
        when(settings) {
            UseSingleNameImportSettings -> Int.MAX_VALUE
            UseImportWithWildcardSettings -> 1
            is UseImportWithWildcardWhenAtLeastNamesUsedSettings -> settings.count
        }
}
