package com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.base.BaseInspectionSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.RedundantSemicolonInspectionOptionsSettings
import com.github.alexandrecarlton.idea.settings.dialog.editor.inspections.kotlin.redundant_constructs.options.UnusedImportDirectiveInspectionOptionsSettings

typealias RedundantSemicolonInspectionSettings = BaseInspectionSettings<RedundantSemicolonInspectionOptionsSettings>
typealias UnusedImportDirectiveInspectionSettings = BaseInspectionSettings<UnusedImportDirectiveInspectionOptionsSettings>

data class KotlinRedundantConstructsInspectionsSettings(

    @JsonProperty("Redundant semicolon")
    val redundantSemicolon: RedundantSemicolonInspectionSettings? = null,

    @JsonProperty("Unused import directive")
    val unusedImportDirective: UnusedImportDirectiveInspectionSettings? = null
)
