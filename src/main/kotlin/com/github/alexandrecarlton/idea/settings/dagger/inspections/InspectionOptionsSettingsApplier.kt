package com.github.alexandrecarlton.idea.settings.dagger.inspections

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryCallToSuperInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryParenthesesInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.layout.editor.inspections.java.code_style_issues.UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings
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
    lateinit var unnecessaryCallToSuperInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryCallToSuperInspectionOptionsSettings>>
    @Inject
    lateinit var unnecessaryParenthesesInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryParenthesesInspectionOptionsSettings>>
    @Inject
    lateinit var unnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplierProvider: Provider<SettingsApplier<UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings>>

    override fun apply(settings: Any) = when (settings) {
        is UnnecessaryCallToSuperInspectionOptionsSettings -> unnecessaryCallToSuperInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnnecessaryParenthesesInspectionOptionsSettings -> unnecessaryParenthesesInspectionOptionsSettingsApplierProvider.get().apply(settings)
        is UnnecessaryQualifierForThisOrSuperInspectionOptionsSettings -> unnecessaryQualifierForThisOrSuperInspectionOptionsSettingsApplierProvider.get().apply(settings)
        else -> LOG.warn("Unhandled inspection options: $settings")
    }

}
