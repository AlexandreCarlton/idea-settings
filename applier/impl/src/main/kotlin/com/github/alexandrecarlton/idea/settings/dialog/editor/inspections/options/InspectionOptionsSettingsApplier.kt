package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.options

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.UnnecessaryCallToSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.code_style_issues.options.UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.javadoc.options.MissingDeprecatedAnnotationInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.java.probable_bugs.options.ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.javascript.code_quality_tools.options.EslintInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.RedundantSemicolonInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.UnusedImportDirectiveInspectionOptionsSettings
import com.intellij.openapi.diagnostic.Logger
import javax.inject.Inject
import javax.inject.Provider

/**
 * Takes in any kind of Options class and apply the relevant settings applier to it.
 */
class InspectionOptionsSettingsApplier @Inject constructor() : SettingsApplier<Any> {

    companion object {
        private val LOG = Logger.getInstance(InspectionOptionsSettingsApplier::class.java)
    }

    // Avoid using constructor to circumvent parameter limits on the constructor.
    @Inject
    lateinit var arrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings: Provider<SettingsApplier<ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings>>
    @Inject
    lateinit var eslintInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<EslintInspectionOptionsSettings>>
    @Inject
    lateinit var missingDeprecatedAnnotationInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<MissingDeprecatedAnnotationInspectionOptionsSettings>>
    @Inject
    lateinit var redundantSemicolonInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<RedundantSemicolonInspectionOptionsSettings>>
    @Inject
    lateinit var unnecessaryCallToSuperInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>>
    @Inject
    lateinit var unnecessaryParenthesesInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>>
    @Inject
    lateinit var unnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>>
    @Inject
    lateinit var unusedImportDirectiveInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnusedImportDirectiveInspectionOptionsSettings>>

    override fun apply(settings: Any) = when (settings) {
        is ArrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings -> arrayComparisonUsingEqualsInsteadOfArraysEqualsInspectionOptionsSettings.get().apply(settings)
        is EslintInspectionOptionsSettings -> eslintInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is MissingDeprecatedAnnotationInspectionOptionsSettings -> missingDeprecatedAnnotationInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is RedundantSemicolonInspectionOptionsSettings -> redundantSemicolonInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnnecessaryCallToSuperInspectionOptionsSettings -> unnecessaryCallToSuperInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnnecessaryParenthesesInspectionOptionsSettings -> unnecessaryParenthesesInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings -> unnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnusedImportDirectiveInspectionOptionsSettings -> unusedImportDirectiveInspectionOptionsSettingsApplierProvider.get().apply(settings)
        else -> LOG.warn("Unhandled inspection options: $settings")
    }

}
